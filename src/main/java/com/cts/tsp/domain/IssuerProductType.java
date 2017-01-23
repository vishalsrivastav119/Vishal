package com.cts.tsp.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the t_456_issuer_product_type database table.
 * 
 */
@Entity
@Table(name = "t_456_issuer_product_type")
@NamedQuery(name = "IssuerProductType.findAll", query = "SELECT i FROM IssuerProductType i")
public class IssuerProductType extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private String recordId;
	private Issuer t454Issuer;
	private ProductType t455ProductType;
	private List<FundingBinRange> t457FundingBinRanges;
	private List<IssuerProdTypeAidVersion> t467IssuerProdTypeAidVersions;

	public IssuerProductType() {
	}

	@Id 
	@Column(name = "RECORD_ID")
	public String getRecordId() {
		return this.recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	// bi-directional many-to-one association to Issuer
	@ManyToOne
	@JoinColumn(name = "ISSUER")
	public Issuer getT454Issuer() {
		return this.t454Issuer;
	}

	public void setT454Issuer(Issuer t454Issuer) {
		this.t454Issuer = t454Issuer;
	}

	// bi-directional many-to-one association to ProductType
	@ManyToOne
	@JoinColumn(name = "PRODUCT")
	public ProductType getT455ProductType() {
		return this.t455ProductType;
	}

	public void setT455ProductType(ProductType t455ProductType) {
		this.t455ProductType = t455ProductType;
	}

	// bi-directional many-to-one association to FundingBinRange
	@OneToMany(mappedBy = "t456IssuerProductType")
	public List<FundingBinRange> getT457FundingBinRanges() {
		return this.t457FundingBinRanges;
	}

	public void setT457FundingBinRanges(
			List<FundingBinRange> t457FundingBinRanges) {
		this.t457FundingBinRanges = t457FundingBinRanges;
	}

	public FundingBinRange addT457FundingBinRange(
			FundingBinRange t457FundingBinRange) {
		getT457FundingBinRanges().add(t457FundingBinRange);
		t457FundingBinRange.setT456IssuerProductType(this);

		return t457FundingBinRange;
	}

	public FundingBinRange removeT457FundingBinRange(
			FundingBinRange t457FundingBinRange) {
		getT457FundingBinRanges().remove(t457FundingBinRange);
		t457FundingBinRange.setT456IssuerProductType(null);

		return t457FundingBinRange;
	}

	// bi-directional many-to-one association to IssuerProdTypeAidVersion
	@OneToMany(mappedBy = "t456IssuerProductType")
	public List<IssuerProdTypeAidVersion> getT467IssuerProdTypeAidVersions() {
		return this.t467IssuerProdTypeAidVersions;
	}

	public void setT467IssuerProdTypeAidVersions(
			List<IssuerProdTypeAidVersion> t467IssuerProdTypeAidVersions) {
		this.t467IssuerProdTypeAidVersions = t467IssuerProdTypeAidVersions;
	}

	public IssuerProdTypeAidVersion addT467IssuerProdTypeAidVersion(
			IssuerProdTypeAidVersion t467IssuerProdTypeAidVersion) {
		getT467IssuerProdTypeAidVersions().add(t467IssuerProdTypeAidVersion);
		t467IssuerProdTypeAidVersion.setT456IssuerProductType(this);

		return t467IssuerProdTypeAidVersion;
	}

	public IssuerProdTypeAidVersion removeT467IssuerProdTypeAidVersion(
			IssuerProdTypeAidVersion t467IssuerProdTypeAidVersion) {
		getT467IssuerProdTypeAidVersions().remove(t467IssuerProdTypeAidVersion);
		t467IssuerProdTypeAidVersion.setT456IssuerProductType(null);

		return t467IssuerProdTypeAidVersion;
	}

}