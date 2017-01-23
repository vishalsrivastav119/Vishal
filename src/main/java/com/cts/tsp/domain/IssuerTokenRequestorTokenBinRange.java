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
 * The persistent class for the t_462_issuer_token_rqstr_token_bin_range
 * database table.
 * 
 */
@Entity
@Table(name = "t_462_issuer_token_rqstr_token_bin_range")
@NamedQuery(name = "IssuerTokenRequestorTokenBinRange.findAll", query = "SELECT i FROM IssuerTokenRequestorTokenBinRange i")
public class IssuerTokenRequestorTokenBinRange extends BaseEntity implements
		Serializable {
	private static final long serialVersionUID = 1L;
	private String recordId;
	private TokenBinRange tokenBinRange;
	private IssuerTokenRequestor issuerTokenRequestor;
	private List<IssuerTokenRequestorAttribute> t465IssuerTokenRqstrAttributes;

	public IssuerTokenRequestorTokenBinRange() {
	}

	@Id
	@Column(name = "RECORD_ID")
	public String getRecordId() {
		return this.recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	// bi-directional many-to-one association to TokenBinRange
	@ManyToOne
	@JoinColumn(name = "TOKEN_BIN_RANGE")
	public TokenBinRange getTokenBinRange() {
		return this.tokenBinRange;
	}

	public void setTokenBinRange(TokenBinRange tokenBinRange) {
		this.tokenBinRange = tokenBinRange;
	}

	// bi-directional many-to-one association to IssuerTokenRequestor
	@ManyToOne
	@JoinColumn(name = "ISSUER_TOKEN_REQUESTOR")
	public IssuerTokenRequestor getIssuerTokenRequestor() {
		return this.issuerTokenRequestor;
	}

	public void setIssuerTokenRequestor(
			IssuerTokenRequestor issuerTokenRequestor) {
		this.issuerTokenRequestor = issuerTokenRequestor;
	}

	// bi-directional many-to-one association to IssuerTokenRequestorAttribute
	@OneToMany(mappedBy = "t462IssuerTokenRqstrTokenBinRange")
	public List<IssuerTokenRequestorAttribute> getT465IssuerTokenRqstrAttributes() {
		return this.t465IssuerTokenRqstrAttributes;
	}

	public void setT465IssuerTokenRqstrAttributes(
			List<IssuerTokenRequestorAttribute> t465IssuerTokenRqstrAttributes) {
		this.t465IssuerTokenRqstrAttributes = t465IssuerTokenRqstrAttributes;
	}

	public IssuerTokenRequestorAttribute addT465IssuerTokenRqstrAttribute(
			IssuerTokenRequestorAttribute t465IssuerTokenRqstrAttribute) {
		getT465IssuerTokenRqstrAttributes().add(t465IssuerTokenRqstrAttribute);
		t465IssuerTokenRqstrAttribute
				.setT462IssuerTokenRqstrTokenBinRange(this);

		return t465IssuerTokenRqstrAttribute;
	}

	public IssuerTokenRequestorAttribute removeT465IssuerTokenRqstrAttribute(
			IssuerTokenRequestorAttribute t465IssuerTokenRqstrAttribute) {
		getT465IssuerTokenRqstrAttributes().remove(
				t465IssuerTokenRqstrAttribute);
		t465IssuerTokenRqstrAttribute
				.setT462IssuerTokenRqstrTokenBinRange(null);

		return t465IssuerTokenRqstrAttribute;
	}

}