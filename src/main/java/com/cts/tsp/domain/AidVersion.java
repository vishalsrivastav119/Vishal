package com.cts.tsp.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the t_466_aid_version database table.
 * 
 */
@Entity
@Table(name="t_466_aid_version")
@NamedQuery(name="AidVersion.findAll", query="SELECT a FROM AidVersion a")
public class AidVersion extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private String recordId;
	private String aid;
	private String version;
	private List<IssuerProdTypeAidVersion> t467IssuerProdTypeAidVersions;

	public AidVersion() {
	}


	@Id
	@Column(name="RECORD_ID")
	public String getRecordId() {
		return this.recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}


	@Column(name="aid")
	public String getAid() {
		return this.aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	@Column(name="version")
	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}


	//bi-directional many-to-one association to IssuerProdTypeAidVersion
	@OneToMany(mappedBy="t466AidVersion")
	public List<IssuerProdTypeAidVersion> getT467IssuerProdTypeAidVersions() {
		return this.t467IssuerProdTypeAidVersions;
	}

	public void setT467IssuerProdTypeAidVersions(List<IssuerProdTypeAidVersion> t467IssuerProdTypeAidVersions) {
		this.t467IssuerProdTypeAidVersions = t467IssuerProdTypeAidVersions;
	}

	public IssuerProdTypeAidVersion addT467IssuerProdTypeAidVersion(IssuerProdTypeAidVersion t467IssuerProdTypeAidVersion) {
		getT467IssuerProdTypeAidVersions().add(t467IssuerProdTypeAidVersion);
		t467IssuerProdTypeAidVersion.setT466AidVersion(this);

		return t467IssuerProdTypeAidVersion;
	}

	public IssuerProdTypeAidVersion removeT467IssuerProdTypeAidVersion(IssuerProdTypeAidVersion t467IssuerProdTypeAidVersion) {
		getT467IssuerProdTypeAidVersions().remove(t467IssuerProdTypeAidVersion);
		t467IssuerProdTypeAidVersion.setT466AidVersion(null);

		return t467IssuerProdTypeAidVersion;
	}

}