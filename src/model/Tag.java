package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Tags database table.
 * 
 */
@Entity
@Table(name="Tags")
public class Tag implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="tag_id")
	private String tagId;

	@Lob
	private String tag;

	public Tag() {
	}

	public String getTagId() {
		return this.tagId;
	}

	public void setTagId(String tagId) {
		this.tagId = tagId;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

}