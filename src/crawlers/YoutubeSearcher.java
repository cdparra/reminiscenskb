/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crawlers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.FuzzyDate;
import model.PublicMemento;

import org.apache.commons.io.IOUtils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * YoutubeSearchers searches music video in youtube based on titles and authors
 * 
 * @author Cristhian (based on Nicola's initial code)
 */
public class YoutubeSearcher {

	private final String youtubeUrlString = "https://gdata.youtube.com/feeds/api/videos?q=";
	private final String youtubeUrlParameterString = "&max-results=2&v=2&alt=jsonc&key=";
	private final String youtubeKeyString = "AI39si7gAsH_3JEgM1dX11kMLFNN8qLlFe-JuAcpz6KCuQ3gKxxzSi0kw7LmTE0znLnkrLi99pIpKNyAwR9A6GUO2u-nrVkXKA";
	private static final String PERSISTENCE_UNIT_NAME = "ReminiscensKB";
	private static EntityManagerFactory factory;
	private static final int LIMIT = 10;

	public YoutubeSearcher() {
	}

	public static void main(String[] a) throws MalformedURLException,
			IOException {
		YoutubeSearcher y = new YoutubeSearcher();
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();

		// Read the first 100 resource entries in the db which do not have a
		// proper resourceURL in the category of SONG
		Query q = em
				.createQuery(
						"select p from PublicMemento p where p.resourceUrl is null and p.category = 'SONG'")
				.setMaxResults(LIMIT);
		List<PublicMemento> publicMementoList = q.getResultList();
		System.out.println("Found " + publicMementoList.size()
				+ " songs without youtube URL");
		System.out.println("Starting to search for videos...");

		// For each video, search the video in youtube
		for (PublicMemento p : publicMementoList) {
			System.out.println("--> Searching '" + p.getHeadline() + "' by '"
					+ p.getAuthor() + "'");
			
			Map<String,String> searchResult = y.getVideoUrl(p.getHeadline(), p.getAuthor());
			String url = searchResult.get("url");
			String text = searchResult.get("text");
			String thumbnail = searchResult.get("thumbnail");

			if (!(url.equals("PROBLEMA"))) {
				System.out.println("=> Found: '" + url + "'");
				p.setResourceUrl(url);
				p.setResourceThumbnailUrl(thumbnail);
				if (p.getText()==null||p.getText().equals("")){
					p.setText(text);
				}
				Date d = new Date();
				p.setLastUpdate(d);
				System.out.print("--> Updatind DB Record with");
				System.out.print(p.getHeadline() + "#");
				System.out.print(p.getAuthor() + "#");
				System.out.print(p.getStartDate().getYear() + "#");
				System.out.print(p.getStartDate().getDecade() + "#");
				System.out.print(p.getText() + "#");
				System.out.println(p.getLastUpdate() + "#");
				System.out.println(p.getResourceUrl());
				System.out.println(p.getResourceThumbnailUrl() + "#");
				em.merge(p);
			}
		}
	}

	// the function only looks for the first video in the list (actually it
	// looks just for one video)
	public Map<String,String> getVideoUrl(String title, String author)
			throws MalformedURLException, IOException {

		String keyword = title + " " + author;
		String urlString = youtubeUrlString
				+ URLEncoder.encode(keyword, "UTF-8")
				+ youtubeUrlParameterString + youtubeKeyString;
		//System.out.println(urlString);
		URL url = new URL(urlString);
		URLConnection conn = url.openConnection();
		ByteArrayOutputStream output = new ByteArrayOutputStream(1024);
		IOUtils.copy(conn.getInputStream(), output);
		output.close();
		System.out.println(output.toString());
		return parseJSON(output.toString());

	}

	public Map<String,String> parseJSON(String json) {
		Map<String,String> result = new HashMap<String,String>();
		
		String url = null;
		String text = null;
		String embed = null;
		String thumbnail = null;

		try {
			JsonElement jelement = new JsonParser().parse(json);
			JsonObject jObj = jelement.getAsJsonObject();
			jObj = jObj.getAsJsonObject("data");
			JsonArray items = jObj.getAsJsonArray("items");
			
			
			
			for (JsonElement jsonElement : items) {
				url = jsonElement.getAsJsonObject().get("content")
						.getAsJsonObject().get("5").getAsString();
				thumbnail = jsonElement.getAsJsonObject().get("thumbnail")
						.getAsJsonObject().get("sqDefaul").getAsString();
				text = jsonElement.getAsJsonObject().get("description").getAsString();
				embed = jsonElement.getAsJsonObject().get("accessControl")
						.getAsJsonObject().get("embed").getAsString();
				
				if (embed!=null && embed.equals("allowed")) {
					break;
				}
			}
		} catch (Exception e) {
			result.put("url", "PROBLEMA");
			return result;
		}

		System.out.println("--> FOUND url = "+url);
		System.out.println("--> FOUND thumbnail = "+thumbnail);
		System.out.println("--> FOUND text = "+text);
		System.out.println("--> FOUND embed = "+embed);

		result.put("url", url);
		result.put("text", text);
		result.put("thumbnail", thumbnail);
		return result;
	}

	public PublicMemento populateSong(String line) {
		String title, author, year, desc;

		PublicMemento song = new PublicMemento();

		int i1 = line.indexOf(',');
		int i2 = line.indexOf(',', i1 + 1);
		int i3 = line.lastIndexOf(',');

		title = line.substring(0, i1);
		author = line.substring(i1 + 1, i2);
		year = line.substring(i2 + 1, i3);
		desc = line.substring(i3 + 1);

		song.setHeadline(title);
		song.setAuthor(author);
		song.setText(desc);

		FuzzyDate releaseDate = new FuzzyDate();
		if (year.matches("^[1-2][0-9][0-9][0-9]$")) {
			releaseDate.setYear(Integer.parseInt(year));
			releaseDate.setDecade(Integer.parseInt(year.substring(0, 3) + "0"));
		}
		song.setStartDate(releaseDate);
		return song;
	}
}
