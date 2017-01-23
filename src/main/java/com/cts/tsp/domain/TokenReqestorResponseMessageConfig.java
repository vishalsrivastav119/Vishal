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
 * The persistent class for the t_471_token_rqstr_resp_msg_cfg database table.
 * 
 */
@Entity
@Table(name = "t_471_token_rqstr_resp_msg_cfg")
@NamedQuery(name = "TokenReqestorResponseMessageConfig.findAll", query = "SELECT t FROM TokenReqestorResponseMessageConfig t")
public class TokenReqestorResponseMessageConfig extends BaseEntity implements
		Serializable {
	private static final long serialVersionUID = 1L;
	private String recordId;
	private String respMessageCfgValue;
	private ResponseMessageConfig t469RespMessageCfg;
	private TokenRequestor t460TokenRequestor;

	public TokenReqestorResponseMessageConfig() {
	}

	@Id
	@Column(name = "RECORD_ID")
	public String getRecordId() {
		return this.recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	@Column(name = "RESP_MESSAGE_CFG_VALUE")
	public String getRespMessageCfgValue() {
		return this.respMessageCfgValue;
	}

	public void setRespMessageCfgValue(String respMessageCfgValue) {
		this.respMessageCfgValue = respMessageCfgValue;
	}

	// bi-directional many-to-one association to ResponseMessageConfig
	@ManyToOne
	@JoinColumn(name = "RESP_MESSAGE_CFG")
	public ResponseMessageConfig getT469RespMessageCfg() {
		return this.t469RespMessageCfg;
	}

	public void setT469RespMessageCfg(ResponseMessageConfig t469RespMessageCfg) {
		this.t469RespMessageCfg = t469RespMessageCfg;
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

}