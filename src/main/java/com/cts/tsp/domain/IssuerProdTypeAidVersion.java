package com.cts.tsp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the t_467_issuer_prod_type_aid_version database
 * table.
 * 
 */
@Entity
@Table(name = "t_467_issuer_prod_type_aid_version")
@NamedQuery(name = "IssuerProdTypeAidVersion.findAll", query = "SELECT i FROM IssuerProdTypeAidVersion i")
public class IssuerProdTypeAidVersion extends BaseEntity implements
		Serializable {
	private static final long serialVersionUID = 1L;
	private String recordId;
	private AidVersion t466AidVersion;
	private IssuerProductType t456IssuerProductType;

	public IssuerProdTypeAidVersion() {
	}

	@Id
	@Column(name = "RECORD_ID")
	public String getRecordId() {
		return this.recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	// bi-directional many-to-one association to AidVersion
	@ManyToOne
	@JoinColumn(name = "AID_VERSION")
	public AidVersion getT466AidVersion() {
		return this.t466AidVersion;
	}

	public void setT466AidVersion(AidVersion t466AidVersion) {
		this.t466AidVersion = t466AidVersion;
	}

	// bi-directional many-to-one association to IssuerProductType
	@ManyToOne
	@JoinColumn(name = "ISSUER_PRODUCT")
	public IssuerProductType getT456IssuerProductType() {
		return this.t456IssuerProductType;
	}

	public void setT456IssuerProductType(IssuerProductType t456IssuerProductType) {
		this.t456IssuerProductType = t456IssuerProductType;
	}

}