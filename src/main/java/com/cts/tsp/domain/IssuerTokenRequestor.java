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
 * The persistent class for the t_461_issuer_token_requestor database table.
 * 
 */
@Entity
@Table(name = "t_461_issuer_token_requestor")
@NamedQuery(name = "IssuerTokenRequestor.findAll", query = "SELECT i FROM IssuerTokenRequestor i")
public class IssuerTokenRequestor extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private String recordId;
	private Issuer t454Issuer;
	private TokenRequestor t460TokenRequestor;
	private List<IssuerTokenRequestorTokenBinRange> t462IssuerTokenRqstrTokenBinRanges;

	public IssuerTokenRequestor() {
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

	// bi-directional many-to-one association to TokenRequestor
	@ManyToOne
	@JoinColumn(name = "TOKEN_REQUESTOR")
	public TokenRequestor getT460TokenRequestor() {
		return this.t460TokenRequestor;
	}

	public void setT460TokenRequestor(TokenRequestor t460TokenRequestor) {
		this.t460TokenRequestor = t460TokenRequestor;
	}

	// bi-directional many-to-one association to
	// IssuerTokenRequestorTokenBinRange
	@OneToMany(mappedBy = "issuerTokenRequestor")
	public List<IssuerTokenRequestorTokenBinRange> getT462IssuerTokenRqstrTokenBinRanges() {
		return this.t462IssuerTokenRqstrTokenBinRanges;
	}

	public void setT462IssuerTokenRqstrTokenBinRanges(
			List<IssuerTokenRequestorTokenBinRange> t462IssuerTokenRqstrTokenBinRanges) {
		this.t462IssuerTokenRqstrTokenBinRanges = t462IssuerTokenRqstrTokenBinRanges;
	}

	public IssuerTokenRequestorTokenBinRange addT462IssuerTokenRqstrTokenBinRange(
			IssuerTokenRequestorTokenBinRange t462IssuerTokenRqstrTokenBinRange) {
		getT462IssuerTokenRqstrTokenBinRanges().add(
				t462IssuerTokenRqstrTokenBinRange);
		t462IssuerTokenRqstrTokenBinRange.setIssuerTokenRequestor(this);

		return t462IssuerTokenRqstrTokenBinRange;
	}

	public IssuerTokenRequestorTokenBinRange removeT462IssuerTokenRqstrTokenBinRange(
			IssuerTokenRequestorTokenBinRange t462IssuerTokenRqstrTokenBinRange) {
		getT462IssuerTokenRqstrTokenBinRanges().remove(
				t462IssuerTokenRqstrTokenBinRange);
		t462IssuerTokenRqstrTokenBinRange.setIssuerTokenRequestor(null);

		return t462IssuerTokenRqstrTokenBinRange;
	}

}