package com.cts.tsp.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the t_455_product_type database table.
 * 
 */
@Entity
@Table(name = "t_455_product_type")
@NamedQuery(name = "ProductType.findAll", query = "SELECT p FROM ProductType p")
public class ProductType extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private String recordId;

	private String productType;
	private String productTypeDesc;
	private List<IssuerProductType> t456IssuerProductTypes;

	public ProductType() {
	}

	@Id
	@Column(name = "RECORD_ID")
	public String getRecordId() {
		return this.recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	@Column(name = "PRODUCT_TYPE")
	public String getProductType() {
		return this.productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	@Column(name = "PRODUCT_TYPE_DESC")
	public String getProductTypeDesc() {
		return this.productTypeDesc;
	}

	public void setProductTypeDesc(String productTypeDesc) {
		this.productTypeDesc = productTypeDesc;
	}

	// bi-directional many-to-one association to IssuerProductType
	@OneToMany(mappedBy = "t455ProductType")
	public List<IssuerProductType> getT456IssuerProductTypes() {
		return this.t456IssuerProductTypes;
	}

	public void setT456IssuerProductTypes(
			List<IssuerProductType> t456IssuerProductTypes) {
		this.t456IssuerProductTypes = t456IssuerProductTypes;
	}

	public IssuerProductType addT456IssuerProductType(
			IssuerProductType t456IssuerProductType) {
		getT456IssuerProductTypes().add(t456IssuerProductType);
		t456IssuerProductType.setT455ProductType(this);

		return t456IssuerProductType;
	}

	public IssuerProductType removeT456IssuerProductType(
			IssuerProductType t456IssuerProductType) {
		getT456IssuerProductTypes().remove(t456IssuerProductType);
		t456IssuerProductType.setT455ProductType(null);

		return t456IssuerProductType;
	}

}