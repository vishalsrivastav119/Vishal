package com.cts.tsp.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the t_479_fpan_token_mapping database table.
 * 
 */
@Entity
@Table(name="t_479_fpan_token_mapping")
@NamedQuery(name="FundingPanTokenMapping.findAll", query="SELECT f FROM FundingPanTokenMapping f")
public class FundingPanTokenMapping extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private String recordId;
	private String fpan;
	private String token;
	private String tokenRequestor;

	public FundingPanTokenMapping() {
	}


	@Id
	@Column(name="RECORD_ID")
	public String getRecordId() {
		return this.recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}


	@Column(name="FPAN")
	public String getFpan() {
		return this.fpan;
	}

	public void setFpan(String fpan) {
		this.fpan = fpan;
	}



	@Column(name="TOKEN")
	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}


	@Column(name="TOKEN_REQUESTOR")
	public String getTokenRequestor() {
		return this.tokenRequestor;
	}

	public void setTokenRequestor(String tokenRequestor) {
		this.tokenRequestor = tokenRequestor;
	}

}