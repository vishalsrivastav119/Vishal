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
 * The persistent class for the t_468_issuer_detoken_resp_field database table.
 * 
 */
@Entity
@Table(name = "t_468_issuer_detoken_resp_field")
@NamedQuery(name = "IssuerDetokenResponseField.findAll", query = "SELECT i FROM IssuerDetokenResponseField i")
public class IssuerDetokenResponseField extends BaseEntity implements
		Serializable {
	private static final long serialVersionUID = 1L;
	private String recordId;
	private DetokenizeResponseField t464DetokenizeRespField;
	private Issuer t454Issuer;

	public IssuerDetokenResponseField() {
	}

	@Id
	@Column(name = "RECORD_ID")
	public String getRecordId() {
		return this.recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	// bi-directional many-to-one association to DetokenizeResponseField
	@ManyToOne
	@JoinColumn(name = "DETOKENIZE_RESP_FIELD")
	public DetokenizeResponseField getT464DetokenizeRespField() {
		return this.t464DetokenizeRespField;
	}

	public void setT464DetokenizeRespField(
			DetokenizeResponseField t464DetokenizeRespField) {
		this.t464DetokenizeRespField = t464DetokenizeRespField;
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

}