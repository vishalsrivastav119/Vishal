package com.cts.tsp.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the t_469_resp_message_cfg database table.
 * 
 */
@Entity
@Table(name = "t_469_resp_message_cfg")
@NamedQuery(name = "ResponseMessageConfig.findAll", query = "SELECT r FROM ResponseMessageConfig r")
public class ResponseMessageConfig extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private String recordId;
	private String respMessageCfgName;
	private String respMessageCfgValue;
	private List<IssuerResponseMessageCfg> t470IssuerRespMessageCfgs;
	private List<TokenReqestorResponseMessageConfig> t471TokenRqstrRespMsgCfgs;

	public ResponseMessageConfig() {
	}

	@Id
	@Column(name = "RECORD_ID")
	public String getRecordId() {
		return this.recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	@Column(name = "RESP_MESSAGE_CFG_NAME")
	public String getRespMessageCfgName() {
		return this.respMessageCfgName;
	}

	public void setRespMessageCfgName(String respMessageCfgName) {
		this.respMessageCfgName = respMessageCfgName;
	}

	@Column(name = "RESP_MESSAGE_CFG_VALUE")
	public String getRespMessageCfgValue() {
		return this.respMessageCfgValue;
	}

	public void setRespMessageCfgValue(String respMessageCfgValue) {
		this.respMessageCfgValue = respMessageCfgValue;
	}

	// bi-directional many-to-one association to IssuerResponseMessageCfg
	@OneToMany(mappedBy = "t469RespMessageCfg")
	public List<IssuerResponseMessageCfg> getT470IssuerRespMessageCfgs() {
		return this.t470IssuerRespMessageCfgs;
	}

	public void setT470IssuerRespMessageCfgs(
			List<IssuerResponseMessageCfg> t470IssuerRespMessageCfgs) {
		this.t470IssuerRespMessageCfgs = t470IssuerRespMessageCfgs;
	}

	public IssuerResponseMessageCfg addT470IssuerRespMessageCfg(
			IssuerResponseMessageCfg t470IssuerRespMessageCfg) {
		getT470IssuerRespMessageCfgs().add(t470IssuerRespMessageCfg);
		t470IssuerRespMessageCfg.setT469RespMessageCfg(this);

		return t470IssuerRespMessageCfg;
	}

	public IssuerResponseMessageCfg removeT470IssuerRespMessageCfg(
			IssuerResponseMessageCfg t470IssuerRespMessageCfg) {
		getT470IssuerRespMessageCfgs().remove(t470IssuerRespMessageCfg);
		t470IssuerRespMessageCfg.setT469RespMessageCfg(null);

		return t470IssuerRespMessageCfg;
	}

	// bi-directional many-to-one association to
	// TokenReqestorResponseMessageConfig
	@OneToMany(mappedBy = "t469RespMessageCfg")
	public List<TokenReqestorResponseMessageConfig> getT471TokenRqstrRespMsgCfgs() {
		return this.t471TokenRqstrRespMsgCfgs;
	}

	public void setT471TokenRqstrRespMsgCfgs(
			List<TokenReqestorResponseMessageConfig> t471TokenRqstrRespMsgCfgs) {
		this.t471TokenRqstrRespMsgCfgs = t471TokenRqstrRespMsgCfgs;
	}

	public TokenReqestorResponseMessageConfig addT471TokenRqstrRespMsgCfg(
			TokenReqestorResponseMessageConfig t471TokenRqstrRespMsgCfg) {
		getT471TokenRqstrRespMsgCfgs().add(t471TokenRqstrRespMsgCfg);
		t471TokenRqstrRespMsgCfg.setT469RespMessageCfg(this);

		return t471TokenRqstrRespMsgCfg;
	}

	public TokenReqestorResponseMessageConfig removeT471TokenRqstrRespMsgCfg(
			TokenReqestorResponseMessageConfig t471TokenRqstrRespMsgCfg) {
		getT471TokenRqstrRespMsgCfgs().remove(t471TokenRqstrRespMsgCfg);
		t471TokenRqstrRespMsgCfg.setT469RespMessageCfg(null);

		return t471TokenRqstrRespMsgCfg;
	}

}