package com.cts.tsp.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the t_457_funding_bin_range database table.
 * 
 */
@Entity
@Table(name="t_457_funding_bin_range")
@NamedQuery(name="FundingBinRange.findAll", query="SELECT f FROM FundingBinRange f")
public class FundingBinRange extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private String recordId;
	private String fundingBinRange;
	private Long fundingBinRangeEnd;
	private Long fundingBinRangeStart;
	private IssuerProductType t456IssuerProductType;
	private List<TokenBinRange> tokenBinRanges;

	public FundingBinRange() {
	}


	@Id
	@Column(name="RECORD_ID")
	public String getRecordId() {
		return this.recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}





	@Column(name="FUNDING_BIN_RANGE")
	public String getFundingBinRange() {
		return this.fundingBinRange;
	}

	public void setFundingBinRange(String fundingBinRange) {
		this.fundingBinRange = fundingBinRange;
	}


	@Column(name="FUNDING_BIN_RANGE_END")
	public Long getFundingBinRangeEnd() {
		return this.fundingBinRangeEnd;
	}

	public void setFundingBinRangeEnd(Long fundingBinRangeEnd) {
		this.fundingBinRangeEnd = fundingBinRangeEnd;
	}


	@Column(name="FUNDING_BIN_RANGE_START")
	public Long getFundingBinRangeStart() {
		return this.fundingBinRangeStart;
	}

	public void setFundingBinRangeStart(Long fundingBinRangeStart) {
		this.fundingBinRangeStart = fundingBinRangeStart;
	}



	//bi-directional many-to-one association to IssuerProductType
	@ManyToOne
	@JoinColumn(name="ISSUER_PRODUCT")
	public IssuerProductType getT456IssuerProductType() {
		return this.t456IssuerProductType;
	}

	public void setT456IssuerProductType(IssuerProductType t456IssuerProductType) {
		this.t456IssuerProductType = t456IssuerProductType;
	}


	//bi-directional many-to-one association to TokenBinRange
	@OneToMany(mappedBy="fundingBinRange")
	public List<TokenBinRange> getTokenBinRanges() {
		return this.tokenBinRanges;
	}

	public void setTokenBinRanges(List<TokenBinRange> tokenBinRanges) {
		this.tokenBinRanges = tokenBinRanges;
	}

	public TokenBinRange addTokenBinRange(TokenBinRange tokenBinRange) {
		getTokenBinRanges().add(tokenBinRange);
		tokenBinRange.setFundingBinRange(this);

		return tokenBinRange;
	}

	public TokenBinRange removeTokenBinRange(TokenBinRange tokenBinRange) {
		getTokenBinRanges().remove(tokenBinRange);
		tokenBinRange.setFundingBinRange(null);

		return tokenBinRange;
	}

}