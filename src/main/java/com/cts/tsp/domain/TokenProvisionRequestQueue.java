package com.cts.tsp.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the t_474_token_provision_req_queue database table.
 * 
 */
@Entity
@Table(name = "t_474_token_provision_req_queue")
@NamedQuery(name = "TokenProvisionRequestQueue.findAll", query = "SELECT t FROM TokenProvisionRequestQueue t")
public class TokenProvisionRequestQueue extends BaseEntity implements
		Serializable {
	private static final long serialVersionUID = 1L;
	private String recordId;
	private String fpan;
	private Date fpanExpDate;
	private String nextStepToken;
	// generated based on lookup
	private int nextStepTokenTotal;
	private String panSource;
	private String token;
	// generated based on lookup
	private Date tokenExpDate;
	
	private String tokenProvisionStts;
	// input
	private String tokenRequestor;
	// 
	private String tokenType;
	private List<TokenProvisionRequestTask> t477TokenProvisionReqTasks;
	private List<TokenProvisionContent> tokenProvisionContents;

	public TokenProvisionRequestQueue() {
	}

	@Id
	@Column(name = "RECORD_ID")
	public String getRecordId() {
		return this.recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public String getFpan() {
		return this.fpan;
	}

	public void setFpan(String fpan) {
		this.fpan = fpan;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FPAN_EXP_DATE")
	public Date getFpanExpDate() {
		return this.fpanExpDate;
	}

	public void setFpanExpDate(Date fpanExpDate) {
		this.fpanExpDate = fpanExpDate;
	}

	@Column(name = "NEXT_STEP_TOKEN")
	public String getNextStepToken() {
		return this.nextStepToken;
	}

	public void setNextStepToken(String nextStepToken) {
		this.nextStepToken = nextStepToken;
	}

	@Column(name = "NEXT_STEP_TOKEN_TOTAL")
	public int getNextStepTokenTotal() {
		return this.nextStepTokenTotal;
	}

	public void setNextStepTokenTotal(int nextStepTokenTotal) {
		this.nextStepTokenTotal = nextStepTokenTotal;
	}

	@Column(name = "PAN_SOURCE")
	public String getPanSource() {
		return this.panSource;
	}

	public void setPanSource(String panSource) {
		this.panSource = panSource;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "TOKEN_EXP_DATE")
	public Date getTokenExpDate() {
		return this.tokenExpDate;
	}

	public void setTokenExpDate(Date tokenExpDate) {
		this.tokenExpDate = tokenExpDate;
	}

	@Column(name = "TOKEN_PROVISION_STTS")
	public String getTokenProvisionStts() {
		return this.tokenProvisionStts;
	}

	public void setTokenProvisionStts(String tokenProvisionStts) {
		this.tokenProvisionStts = tokenProvisionStts;
	}

	@Column(name = "TOKEN_REQUESTOR")
	public String getTokenRequestor() {
		return this.tokenRequestor;
	}

	public void setTokenRequestor(String tokenRequestor) {
		this.tokenRequestor = tokenRequestor;
	}

	@Column(name = "TOKEN_TYPE")
	public String getTokenType() {
		return this.tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	// bi-directional many-to-one association to TokenProvisionRequestTask
	@OneToMany(mappedBy = "t474TokenProvisionReqQueue")
	public List<TokenProvisionRequestTask> getT477TokenProvisionReqTasks() {
		return this.t477TokenProvisionReqTasks;
	}

	public void setT477TokenProvisionReqTasks(
			List<TokenProvisionRequestTask> t477TokenProvisionReqTasks) {
		this.t477TokenProvisionReqTasks = t477TokenProvisionReqTasks;
	}

	public TokenProvisionRequestTask addT477TokenProvisionReqTask(
			TokenProvisionRequestTask t477TokenProvisionReqTask) {
		getT477TokenProvisionReqTasks().add(t477TokenProvisionReqTask);
		t477TokenProvisionReqTask.setT474TokenProvisionReqQueue(this);

		return t477TokenProvisionReqTask;
	}

	public TokenProvisionRequestTask removeT477TokenProvisionReqTask(
			TokenProvisionRequestTask t477TokenProvisionReqTask) {
		getT477TokenProvisionReqTasks().remove(t477TokenProvisionReqTask);
		t477TokenProvisionReqTask.setT474TokenProvisionReqQueue(null);

		return t477TokenProvisionReqTask;
	}
	
	@PrePersist
	public void setRecordId(){
		this.setRecordId("474" + (long)((Math.random()*10000000000L)+10L));
		this.setCreatedBy("111033");
		this.setUpdatedBy("111033");
		this.setCreatedTs(new Timestamp( new Date().getTime()));
		this.setUpdatedTs(this.getCreatedTs());

	}

	/**
	 * @return the tokenProvisionContents
	 */
	@OneToMany(mappedBy="requestQueue", cascade=CascadeType.ALL)
	public List<TokenProvisionContent> getTokenProvisionContents() {
		return tokenProvisionContents;
	}

	/**
	 * @param tokenProvisionContents the tokenProvisionContents to set
	 */
	public void setTokenProvisionContents(
			List<TokenProvisionContent> tokenProvisionContents) {
		this.tokenProvisionContents = tokenProvisionContents;
	}
}