package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Fuzzy_Date database table.
 * 
 */
@Entity
@Table(name="Fuzzy_Date")
public class FuzzyDate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="fuzzy_date_id")
	private String fuzzyDateId;

	private String accuracy;

	private short day;

	private int decade;

	@Temporal(TemporalType.DATE)
	@Column(name="exact_date")
	private Date exactDate;

	private String locale;

	private short month;

	@Lob
	@Column(name="textual_date")
	private String textualDate;

	private int year;

	public FuzzyDate() {
	}

	public String getFuzzyDateId() {
		return this.fuzzyDateId;
	}

	public void setFuzzyDateId(String fuzzyDateId) {
		this.fuzzyDateId = fuzzyDateId;
	}

	public String getAccuracy() {
		return this.accuracy;
	}

	public void setAccuracy(String accuracy) {
		this.accuracy = accuracy;
	}

	public short getDay() {
		return this.day;
	}

	public void setDay(short day) {
		this.day = day;
	}

	public int getDecade() {
		return this.decade;
	}

	public void setDecade(int decade) {
		this.decade = decade;
	}

	public Date getExactDate() {
		return this.exactDate;
	}

	public void setExactDate(Date exactDate) {
		this.exactDate = exactDate;
	}

	public String getLocale() {
		return this.locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public short getMonth() {
		return this.month;
	}

	public void setMonth(short month) {
		this.month = month;
	}

	public String getTextualDate() {
		return this.textualDate;
	}

	public void setTextualDate(String textualDate) {
		this.textualDate = textualDate;
	}

	public int getYear() {
		return this.year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}