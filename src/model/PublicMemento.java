package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Public_Memento database table.
 * 
 */
@Entity
@Table(name="Public_Memento")
public class PublicMemento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="public_memento_id")
	private String publicMementoId;

	private String author;

	private String category;

	private String collection;

	@Column(name="collection_type")
	private String collectionType;

	private int contributor;

	@Column(name="contributor_type")
	private String contributorType;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="creation_date")
	private Date creationDate;

	@Column
	private String headline;

	@Column(name="is_collection")
	private short isCollection;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_update")
	private Date lastUpdate;

	@Column
	private String locale;

	private String nationality;

	@Column(name="resource_thumbnail_url")
	private String resourceThumbnailUrl;

	@Column(name="resource_type")
	private String resourceType;

	@Column(name="resource_url")
	private String resourceUrl;

	private String source;

	@Column(name="source_url")
	private String sourceUrl;

	@Column(name="text")
	private String text;

	@Column
	private String type;

	//uni-directional many-to-one association to FuzzyDate
	@ManyToOne
	@JoinColumn(name="fuzzy_enddate")
	private FuzzyDate endDate;

	//uni-directional many-to-one association to Location
	@ManyToOne
	@JoinColumn(name="location_end_id")
	private Location endLocation;

	//uni-directional many-to-one association to FuzzyDate
	@ManyToOne
	@JoinColumn(name="fuzzy_startdate")
	private FuzzyDate startDate;

	//uni-directional many-to-one association to Location
	@ManyToOne
	@JoinColumn(name="location_start_id")
	private Location startLocation;

	public PublicMemento() {
	}

	public String getPublicMementoId() {
		return this.publicMementoId;
	}

	public void setPublicMementoId(String publicMementoId) {
		this.publicMementoId = publicMementoId;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCollection() {
		return this.collection;
	}

	public void setCollection(String collection) {
		this.collection = collection;
	}

	public String getCollectionType() {
		return this.collectionType;
	}

	public void setCollectionType(String collectionType) {
		this.collectionType = collectionType;
	}

	public int getContributor() {
		return this.contributor;
	}

	public void setContributor(int contributor) {
		this.contributor = contributor;
	}

	public String getContributorType() {
		return this.contributorType;
	}

	public void setContributorType(String contributorType) {
		this.contributorType = contributorType;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getHeadline() {
		return this.headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public short getIsCollection() {
		return this.isCollection;
	}

	public void setIsCollection(short isCollection) {
		this.isCollection = isCollection;
	}

	public Date getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getLocale() {
		return this.locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getNationality() {
		return this.nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getResourceThumbnailUrl() {
		return this.resourceThumbnailUrl;
	}

	public void setResourceThumbnailUrl(String resourceThumbnailUrl) {
		this.resourceThumbnailUrl = resourceThumbnailUrl;
	}

	public String getResourceType() {
		return this.resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public String getResourceUrl() {
		return this.resourceUrl;
	}

	public void setResourceUrl(String resourceUrl) {
		this.resourceUrl = resourceUrl;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSourceUrl() {
		return this.sourceUrl;
	}

	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public FuzzyDate getEndDate() {
		return this.endDate;
	}

	public void setEndDate(FuzzyDate endDate) {
		this.endDate = endDate;
	}

	public Location getEndLocation() {
		return this.endLocation;
	}

	public void setEndLocation(Location endLocation) {
		this.endLocation = endLocation;
	}

	public FuzzyDate getStartDate() {
		return this.startDate;
	}

	public void setStartDate(FuzzyDate startDate) {
		this.startDate = startDate;
	}

	public Location getStartLocation() {
		return this.startLocation;
	}

	public void setStartLocation(Location startLocation) {
		this.startLocation = startLocation;
	}

}