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
 * The persistent class for the t_460_token_requestor database table.
 * 
 */
@Entity
@Table(name = "t_460_token_requestor")
@NamedQuery(name = "TokenRequestor.findAll", query = "SELECT t FROM TokenRequestor t")
public class TokenRequestor extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private String recordId;
	private String tokenRequestorDesc;
	private String tokenRequestorName;
	private TokenRequestorType t459TokenRequestorType;
	private List<IssuerTokenRequestor> t461IssuerTokenRequestors;
	private List<TokenRequestorAttribute> t463TokenRequestorAttributes;
	private List<TokenReqestorResponseMessageConfig> t471TokenRqstrRespMsgCfgs;

	public TokenRequestor() {
	}

	@Id
	@Column(name = "RECORD_ID")
	public String getRecordId() {
		return this.recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	@Column(name = "TOKEN_REQUESTOR_DESC")
	public String getTokenRequestorDesc() {
		return this.tokenRequestorDesc;
	}

	public void setTokenRequestorDesc(String tokenRequestorDesc) {
		this.tokenRequestorDesc = tokenRequestorDesc;
	}

	@Column(name = "TOKEN_REQUESTOR_NAME")
	public String getTokenRequestorName() {
		return this.tokenRequestorName;
	}

	public void setTokenRequestorName(String tokenRequestorName) {
		this.tokenRequestorName = tokenRequestorName;
	}

	// bi-directional many-to-one association to TokenRequestorType
	@ManyToOne
	@JoinColumn(name = "TOKEN_REQUESTOR_TYPE")
	public TokenRequestorType getT459TokenRequestorType() {
		return this.t459TokenRequestorType;
	}

	public void setT459TokenRequestorType(
			TokenRequestorType t459TokenRequestorType) {
		this.t459TokenRequestorType = t459TokenRequestorType;
	}

	// bi-directional many-to-one association to IssuerTokenRequestor
	@OneToMany(mappedBy = "t460TokenRequestor")
	public List<IssuerTokenRequestor> getT461IssuerTokenRequestors() {
		return this.t461IssuerTokenRequestors;
	}

	public void setT461IssuerTokenRequestors(
			List<IssuerTokenRequestor> t461IssuerTokenRequestors) {
		this.t461IssuerTokenRequestors = t461IssuerTokenRequestors;
	}

	public IssuerTokenRequestor addT461IssuerTokenRequestor(
			IssuerTokenRequestor t461IssuerTokenRequestor) {
		getT461IssuerTokenRequestors().add(t461IssuerTokenRequestor);
		t461IssuerTokenRequestor.setT460TokenRequestor(this);

		return t461IssuerTokenRequestor;
	}

	public IssuerTokenRequestor removeT461IssuerTokenRequestor(
			IssuerTokenRequestor t461IssuerTokenRequestor) {
		getT461IssuerTokenRequestors().remove(t461IssuerTokenRequestor);
		t461IssuerTokenRequestor.setT460TokenRequestor(null);

		return t461IssuerTokenRequestor;
	}

	// bi-directional many-to-one association to TokenRequestorAttribute
	@OneToMany(mappedBy = "t460TokenRequestor")
	public List<TokenRequestorAttribute> getT463TokenRequestorAttributes() {
		return this.t463TokenRequestorAttributes;
	}

	public void setT463TokenRequestorAttributes(
			List<TokenRequestorAttribute> t463TokenRequestorAttributes) {
		this.t463TokenRequestorAttributes = t463TokenRequestorAttributes;
	}

	public TokenRequestorAttribute addT463TokenRequestorAttribute(
			TokenRequestorAttribute t463TokenRequestorAttribute) {
		getT463TokenRequestorAttributes().add(t463TokenRequestorAttribute);
		t463TokenRequestorAttribute.setT460TokenRequestor(this);

		return t463TokenRequestorAttribute;
	}

	public TokenRequestorAttribute removeT463TokenRequestorAttribute(
			TokenRequestorAttribute t463TokenRequestorAttribute) {
		getT463TokenRequestorAttributes().remove(t463TokenRequestorAttribute);
		t463TokenRequestorAttribute.setT460TokenRequestor(null);

		return t463TokenRequestorAttribute;
	}

	// bi-directional many-to-one association to
	// TokenReqestorResponseMessageConfig
	@OneToMany(mappedBy = "t460TokenRequestor")
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
		t471TokenRqstrRespMsgCfg.setT460TokenRequestor(this);

		return t471TokenRqstrRespMsgCfg;
	}

	public TokenReqestorResponseMessageConfig removeT471TokenRqstrRespMsgCfg(
			TokenReqestorResponseMessageConfig t471TokenRqstrRespMsgCfg) {
		getT471TokenRqstrRespMsgCfgs().remove(t471TokenRqstrRespMsgCfg);
		t471TokenRqstrRespMsgCfg.setT460TokenRequestor(null);

		return t471TokenRqstrRespMsgCfg;
	}
}