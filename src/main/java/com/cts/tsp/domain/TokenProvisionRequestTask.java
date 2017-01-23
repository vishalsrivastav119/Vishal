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
 * The persistent class for the t_477_token_provision_req_task database table.
 * 
 */
@Entity
@Table(name = "t_477_token_provision_req_task")
@NamedQuery(name = "TokenProvisionRequestTask.findAll", query = "SELECT t FROM TokenProvisionRequestTask t")
public class TokenProvisionRequestTask extends BaseEntity implements
		Serializable {
	private static final long serialVersionUID = 1L;
	private String recordId;
	private String taskStatus;
	private TokenProvisionRequestQueue t474TokenProvisionReqQueue;

	public TokenProvisionRequestTask() {
	}

	@Id
	@Column(name = "RECORD_ID")
	public String getRecordId() {
		return this.recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	@Column(name = "TASK_STATUS")
	public String getTaskStatus() {
		return this.taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	// bi-directional many-to-one association to TokenProvisionRequestQueue
	@ManyToOne
	@JoinColumn(name = "TOKEN_PROVISION_REQ_Q")
	public TokenProvisionRequestQueue getT474TokenProvisionReqQueue() {
		return this.t474TokenProvisionReqQueue;
	}

	public void setT474TokenProvisionReqQueue(
			TokenProvisionRequestQueue t474TokenProvisionReqQueue) {
		this.t474TokenProvisionReqQueue = t474TokenProvisionReqQueue;
	}

}