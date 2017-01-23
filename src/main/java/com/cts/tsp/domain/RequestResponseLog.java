package com.cts.tsp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the t_476_req_resp_log database table.
 * 
 */
@Entity
@Table(name = "t_476_req_resp_log")
@NamedQuery(name = "RequestResponseLog.findAll", query = "SELECT r FROM RequestResponseLog r")
public class RequestResponseLog extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private String recordId;
	private String reqestPayload;
	private String responsePayload;
	private String responseStatus;

	public RequestResponseLog() {
	}

	@Id
	@Column(name = "RECORD_ID")
	public String getRecordId() {
		return this.recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	@Column(name = "REQEST_PAYLOAD")
	public String getReqestPayload() {
		return this.reqestPayload;
	}

	public void setReqestPayload(String reqestPayload) {
		this.reqestPayload = reqestPayload;
	}

	@Column(name = "RESPONSE_PAYLOAD")
	public String getResponsePayload() {
		return this.responsePayload;
	}

	public void setResponsePayload(String responsePayload) {
		this.responsePayload = responsePayload;
	}

	@Column(name = "RESPONSE_STATUS")
	public String getResponseStatus() {
		return this.responseStatus;
	}

	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}

}