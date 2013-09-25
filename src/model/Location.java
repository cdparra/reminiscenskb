package model;

import java.io.Serializable;
import javax.persistence.*;

import java.math.BigDecimal;


/**
 * The persistent class for the Location database table.
 * 
 */
@Entity
@Table(name="Location")
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="location_id")
	private String locationId;

	private short accuracy;

	@Lob
	private String city;

	@Column(name="city_id")
	private int cityId;

	@Lob
	private String country;

	private String locale;

	@Lob
	@Column(name="location_textual")
	private String locationTextual;

	@Lob
	private String region;

	public Location() {
	}

	public String getLocationId() {
		return this.locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public short getAccuracy() {
		return this.accuracy;
	}

	public void setAccuracy(short accuracy) {
		this.accuracy = accuracy;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getCityId() {
		return this.cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLocale() {
		return this.locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getLocationTextual() {
		return this.locationTextual;
	}

	public void setLocationTextual(String locationTextual) {
		this.locationTextual = locationTextual;
	}

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

}