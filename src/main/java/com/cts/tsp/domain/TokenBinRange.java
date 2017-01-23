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
 * The persistent class for the t_458_token_bin_range database table.
 * 
 */
@Entity
@Table(name = "t_458_token_bin_range")
@NamedQuery(name = "TokenBinRange.findAll", query = "SELECT t FROM TokenBinRange t")
public class TokenBinRange extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private String recordId;
	private String tokenBeanRange;
	private Long tokenBinRangeEnd;
	private Long tokenBinRangeStart;
	private FundingBinRange FundingBinRange;
	private List<IssuerTokenRequestorTokenBinRange> t462IssuerTokenRqstrTokenBinRanges;

	public TokenBinRange() {
	}

	@Id
	@Column(name = "RECORD_ID")
	public String getRecordId() {
		return this.recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	@Column(name = "TOKEN_BEAN_RANGE")
	public String getTokenBeanRange() {
		return this.tokenBeanRange;
	}

	public void setTokenBeanRange(String tokenBeanRange) {
		this.tokenBeanRange = tokenBeanRange;
	}

	@Column(name = "TOKEN_BIN_RANGE_END")
	public Long getTokenBinRangeEnd() {
		return this.tokenBinRangeEnd;
	}

	public void setTokenBinRangeEnd(Long tokenBinRangeEnd) {
		this.tokenBinRangeEnd = tokenBinRangeEnd;
	}

	@Column(name = "TOKEN_BIN_RANGE_START")
	public Long getTokenBinRangeStart() {
		return this.tokenBinRangeStart;
	}

	public void setTokenBinRangeStart(Long tokenBinRangeStart) {
		this.tokenBinRangeStart = tokenBinRangeStart;
	}

	// bi-directional many-to-one association to FundingBinRange
	@ManyToOne
	@JoinColumn(name = "FUNDING_BIN")
	public FundingBinRange getFundingBinRange() {
		return this.FundingBinRange;
	}

	public void setFundingBinRange(FundingBinRange FundingBinRange) {
		this.FundingBinRange = FundingBinRange;
	}

	// bi-directional many-to-one association to
	// IssuerTokenRequestorTokenBinRange
	@OneToMany(mappedBy = "tokenBinRange")
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
		t462IssuerTokenRqstrTokenBinRange.setTokenBinRange(this);

		return t462IssuerTokenRqstrTokenBinRange;
	}

	public IssuerTokenRequestorTokenBinRange removeT462IssuerTokenRqstrTokenBinRange(
			IssuerTokenRequestorTokenBinRange t462IssuerTokenRqstrTokenBinRange) {
		getT462IssuerTokenRqstrTokenBinRanges().remove(
				t462IssuerTokenRqstrTokenBinRange);
		t462IssuerTokenRqstrTokenBinRange.setTokenBinRange(null);

		return t462IssuerTokenRqstrTokenBinRange;
	}

}