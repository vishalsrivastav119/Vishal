package com.cts.tsp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the t_454_issuer database table.
 * 
 */
@Entity
@Table(name="t_454_issuer")
@NamedQuery(name="Issuer.findAll", query="SELECT i FROM Issuer i")
public class Issuer extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private String recordId;
	private String issuerCountry;
	private String issuerName;
	
	public Issuer() {
	}


	@Id
	@Column(name="RECORD_ID", length=14)
	public String getRecordId() {
		return this.recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	@Column(name="ISSUER_COUNTRY")
	public String getIssuerCountry() {
		return this.issuerCountry;
	}

	public void setIssuerCountry(String issuerCountry) {
		this.issuerCountry = issuerCountry;
	}


	@Column(name="ISSUER_NAME")
	public String getIssuerName() {
		return this.issuerName;
	}

	public void setIssuerName(String issuerName) {
		this.issuerName = issuerName;
	}
}