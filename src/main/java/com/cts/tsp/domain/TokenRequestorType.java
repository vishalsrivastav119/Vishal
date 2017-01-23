package com.cts.tsp.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the t_459_token_requestor_type database table.
 * 
 */
@Entity
@Table(name = "t_459_token_requestor_type")
@NamedQuery(name = "TokenRequestorType.findAll", query = "SELECT t FROM TokenRequestorType t")
public class TokenRequestorType extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private String recordId;
	private String tokenRequestorType;
	private String tokenRequestorTypeDesc;
	private List<TokenRequestor> t460TokenRequestors;

	public TokenRequestorType() {
	}

	@Id
	@Column(name = "RECORD_ID")
	public String getRecordId() {
		return this.recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	@Column(name = "TOKEN_REQUESTOR_TYPE")
	public String getTokenRequestorType() {
		return this.tokenRequestorType;
	}

	public void setTokenRequestorType(String tokenRequestorType) {
		this.tokenRequestorType = tokenRequestorType;
	}

	@Column(name = "TOKEN_REQUESTOR_TYPE_DESC")
	public String getTokenRequestorTypeDesc() {
		return this.tokenRequestorTypeDesc;
	}

	public void setTokenRequestorTypeDesc(String tokenRequestorTypeDesc) {
		this.tokenRequestorTypeDesc = tokenRequestorTypeDesc;
	}

	// bi-directional many-to-one association to TokenRequestor
	@OneToMany(mappedBy = "t459TokenRequestorType")
	public List<TokenRequestor> getT460TokenRequestors() {
		return this.t460TokenRequestors;
	}

	public void setT460TokenRequestors(List<TokenRequestor> t460TokenRequestors) {
		this.t460TokenRequestors = t460TokenRequestors;
	}

	public TokenRequestor addT460TokenRequestor(
			TokenRequestor t460TokenRequestor) {
		getT460TokenRequestors().add(t460TokenRequestor);
		t460TokenRequestor.setT459TokenRequestorType(this);

		return t460TokenRequestor;
	}

	public TokenRequestor removeT460TokenRequestor(
			TokenRequestor t460TokenRequestor) {
		getT460TokenRequestors().remove(t460TokenRequestor);
		t460TokenRequestor.setT459TokenRequestorType(null);

		return t460TokenRequestor;
	}

}