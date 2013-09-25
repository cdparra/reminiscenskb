package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the City database table.
 * 
 */
@Entity
@Table(name="City")
public class City implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="city_id")
	private int cityId;

	@Column(name="city_name")
	private String cityName;

	@Column(name="country_id")
	private int countryId;

	@Column(name="english_name")
	private String englishName;

	@Column(name="english_region")
	private String englishRegion;

	@Column(name="french_name")
	private String frenchName;

	@Column(name="french_region")
	private String frenchRegion;

	@Column(name="german_name")
	private String germanName;

	@Column(name="german_region")
	private String germanRegion;

	@Column(name="italian_name")
	private String italianName;

	@Column(name="italian_region")
	private String italianRegion;

	private BigDecimal lat;

	private String locale;

	private BigDecimal lon;

	@Column(name="portuguese_name")
	private String portugueseName;

	@Column(name="portuguese_region")
	private String portugueseRegion;

	private String region;

	@Column(name="spanish_name")
	private String spanishName;

	@Column(name="spanish_region")
	private String spanishRegion;

	public City() {
	}

	public int getCityId() {
		return this.cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public int getCountryId() {
		return this.countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getEnglishName() {
		return this.englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public String getEnglishRegion() {
		return this.englishRegion;
	}

	public void setEnglishRegion(String englishRegion) {
		this.englishRegion = englishRegion;
	}

	public String getFrenchName() {
		return this.frenchName;
	}

	public void setFrenchName(String frenchName) {
		this.frenchName = frenchName;
	}

	public String getFrenchRegion() {
		return this.frenchRegion;
	}

	public void setFrenchRegion(String frenchRegion) {
		this.frenchRegion = frenchRegion;
	}

	public String getGermanName() {
		return this.germanName;
	}

	public void setGermanName(String germanName) {
		this.germanName = germanName;
	}

	public String getGermanRegion() {
		return this.germanRegion;
	}

	public void setGermanRegion(String germanRegion) {
		this.germanRegion = germanRegion;
	}

	public String getItalianName() {
		return this.italianName;
	}

	public void setItalianName(String italianName) {
		this.italianName = italianName;
	}

	public String getItalianRegion() {
		return this.italianRegion;
	}

	public void setItalianRegion(String italianRegion) {
		this.italianRegion = italianRegion;
	}

	public BigDecimal getLat() {
		return this.lat;
	}

	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}

	public String getLocale() {
		return this.locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public BigDecimal getLon() {
		return this.lon;
	}

	public void setLon(BigDecimal lon) {
		this.lon = lon;
	}

	public String getPortugueseName() {
		return this.portugueseName;
	}

	public void setPortugueseName(String portugueseName) {
		this.portugueseName = portugueseName;
	}

	public String getPortugueseRegion() {
		return this.portugueseRegion;
	}

	public void setPortugueseRegion(String portugueseRegion) {
		this.portugueseRegion = portugueseRegion;
	}

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getSpanishName() {
		return this.spanishName;
	}

	public void setSpanishName(String spanishName) {
		this.spanishName = spanishName;
	}

	public String getSpanishRegion() {
		return this.spanishRegion;
	}

	public void setSpanishRegion(String spanishRegion) {
		this.spanishRegion = spanishRegion;
	}

}