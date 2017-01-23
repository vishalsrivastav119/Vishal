package com.cts.tsp.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.Table;

/**
 * The persistent class for the t_465_issuer_token_rqstr_attribute database
 * table.
 * 
 */
@Entity
@Table(name = "t_465_issuer_token_rqstr_attribute")
@NamedQuery(name = "IssuerTokenRequestorAttribute.findAll", query = "SELECT i FROM IssuerTokenRequestorAttribute i")
public class IssuerTokenRequestorAttribute extends BaseEntity implements
		Serializable {
	private static final long serialVersionUID = 1L;
	private String recordId;
	private String tokenRqstrAttributeValue;
	private IssuerTokenRequestorTokenBinRange t462IssuerTokenRqstrTokenBinRange;
	private TokenRequestorAttribute t463TokenRequestorAttribute;

	public IssuerTokenRequestorAttribute() {
	}

	@Id
	@Column(name = "RECORD_ID")
	public String getRecordId() {
		return this.recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	@Column(name = "TOKEN_RQSTR_ATTRIBUTE_VALUE")
	public String getTokenRqstrAttributeValue() {
		return this.tokenRqstrAttributeValue;
	}

	public void setTokenRqstrAttributeValue(String tokenRqstrAttributeValue) {
		this.tokenRqstrAttributeValue = tokenRqstrAttributeValue;
	}

	// bi-directional many-to-one association to
	// IssuerTokenRequestorTokenBinRange
	@ManyToOne
	@JoinColumn(name = "ISSUER_TOKEN_RQ_TOKEN_BIN_RANGE")
	public IssuerTokenRequestorTokenBinRange getT462IssuerTokenRqstrTokenBinRange() {
		return this.t462IssuerTokenRqstrTokenBinRange;
	}

	public void setT462IssuerTokenRqstrTokenBinRange(
			IssuerTokenRequestorTokenBinRange t462IssuerTokenRqstrTokenBinRange) {
		this.t462IssuerTokenRqstrTokenBinRange = t462IssuerTokenRqstrTokenBinRange;
	}

	// bi-directional many-to-one association to TokenRequestorAttribute
	@ManyToOne
	@JoinColumn(name = "TOKEN_REQUESTOR_ATTRIBUTE")
	public TokenRequestorAttribute getT463TokenRequestorAttribute() {
		return this.t463TokenRequestorAttribute;
	}

	public void setT463TokenRequestorAttribute(
			TokenRequestorAttribute t463TokenRequestorAttribute) {
		this.t463TokenRequestorAttribute = t463TokenRequestorAttribute;
	}
	
	@PrePersist
	public void setRecordId(){
		this.setRecordId("478" + (long)((Math.random()*10000000000L)+10L));
		this.setCreatedBy("111033");
		this.setUpdatedBy("111033");
		this.setCreatedTs(new Timestamp( new Date().getTime()));
		this.setUpdatedTs(this.getCreatedTs());

	}


}