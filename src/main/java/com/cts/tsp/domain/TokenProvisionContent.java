package com.cts.tsp.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.Table;

/**
 * The persistent class for the t_478_token_provision_content database table.
 * 
 */
@Entity
@Table(name = "t_478_token_provision_content")
@NamedQuery(name = "TokenProvisionContent.findAll", query = "SELECT t FROM TokenProvisionContent t")
public class TokenProvisionContent extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private String recordId;
	private String attributeName;
	private String attributeValue;
	private String tokenProvisionContGuiId;
	private TokenProvisionRequestQueue requestQueue;
	

	public TokenProvisionContent() {
	}

	@Id
	@Column(name = "RECORD_ID")
	public String getRecordId() {
		return this.recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	@Column(name = "ATTRIBUTE_NAME")
	public String getAttributeName() {
		return this.attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	@Column(name = "ATTRIBUTE_VALUE")
	public String getAttributeValue() {
		return this.attributeValue;
	}

	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}

	@Column(name = "TOKEN_PROVISION_CONT_GUI_ID")
	public String getTokenProvisionContGuiId() {
		return this.tokenProvisionContGuiId;
	}

	public void setTokenProvisionContGuiId(String tokenProvisionContGuiId) {
		this.tokenProvisionContGuiId = tokenProvisionContGuiId;
	}

	/**
	 * @return the requestQueue
	 */
	// bi-directional many-to-one association to FundingBinRange
	@ManyToOne
	@JoinColumn(name = "TOKEN_PROVISION_REQ_Q")
	public TokenProvisionRequestQueue getRequestQueue() {
		return requestQueue;
	}

	/**
	 * @param requestQueue the requestQueue to set
	 */
	public void setRequestQueue(TokenProvisionRequestQueue requestQueue) {
		this.requestQueue = requestQueue;
	}
	
	@PrePersist
	public void setRecordId(){
		this.setRecordId("478" + (long)((Math.random()*10000000000L)+10L));
		this.setCreatedBy("111033");
		this.setUpdatedBy("111033");
		this.setCreatedTs(new Timestamp( new Date().getTime()));
		this.setUpdatedTs(this.getCreatedTs());

	}
}