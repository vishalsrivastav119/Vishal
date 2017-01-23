package com.cts.tsp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the t_470_issuer_resp_message_cfg database table.
 * 
 */
@Entity
@Table(name = "t_470_issuer_resp_message_cfg")
@NamedQuery(name = "IssuerResponseMessageCfg.findAll", query = "SELECT i FROM IssuerResponseMessageCfg i")
public class IssuerResponseMessageCfg extends BaseEntity implements
		Serializable {
	private static final long serialVersionUID = 1L;
	private String recordId;
	private String respMessageCfgValue;
	private ResponseMessageConfig t469RespMessageCfg;
	private Issuer t454Issuer;

	public IssuerResponseMessageCfg() {
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

	// bi-directional many-to-one association to Issuer
	@ManyToOne
	@JoinColumn(name = "ISSUER")
	public Issuer getT454Issuer() {
		return this.t454Issuer;
	}

	public void setT454Issuer(Issuer t454Issuer) {
		this.t454Issuer = t454Issuer;
	}

}