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
 * The persistent class for the t_463_token_requestor_attribute database table.
 * 
 */
@Entity
@Table(name = "t_463_token_requestor_attribute")
@NamedQuery(name = "TokenRequestorAttribute.findAll", query = "SELECT t FROM TokenRequestorAttribute t")
public class TokenRequestorAttribute extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private String recordId;
	private String tokenRequestorAttributeDesc;
	private String tokenRequestorAttributeName;
	private TokenRequestor t460TokenRequestor;
	private Boolean guidRequired;
	private List<IssuerTokenRequestorAttribute> t465IssuerTokenRqstrAttributes;

	public TokenRequestorAttribute() {
	}

	@Id
	@Column(name = "RECORD_ID")
	public String getRecordId() {
		return this.recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	@Column(name = "TOKEN_REQUESTOR_ATTRIBUTE_DESC")
	public String getTokenRequestorAttributeDesc() {
		return this.tokenRequestorAttributeDesc;
	}

	public void setTokenRequestorAttributeDesc(
			String tokenRequestorAttributeDesc) {
		this.tokenRequestorAttributeDesc = tokenRequestorAttributeDesc;
	}

	@Column(name = "TOKEN_REQUESTOR_ATTRIBUTE_NAME")
	public String getTokenRequestorAttributeName() {
		return this.tokenRequestorAttributeName;
	}

	public void setTokenRequestorAttributeName(
			String tokenRequestorAttributeName) {
		this.tokenRequestorAttributeName = tokenRequestorAttributeName;
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

	// bi-directional many-to-one association to IssuerTokenRequestorAttribute
	@OneToMany(mappedBy = "t463TokenRequestorAttribute")
	public List<IssuerTokenRequestorAttribute> getT465IssuerTokenRqstrAttributes() {
		return this.t465IssuerTokenRqstrAttributes;
	}

	public void setT465IssuerTokenRqstrAttributes(
			List<IssuerTokenRequestorAttribute> t465IssuerTokenRqstrAttributes) {
		this.t465IssuerTokenRqstrAttributes = t465IssuerTokenRqstrAttributes;
	}

	public IssuerTokenRequestorAttribute addT465IssuerTokenRqstrAttribute(
			IssuerTokenRequestorAttribute t465IssuerTokenRqstrAttribute) {
		getT465IssuerTokenRqstrAttributes().add(t465IssuerTokenRqstrAttribute);
		t465IssuerTokenRqstrAttribute.setT463TokenRequestorAttribute(this);

		return t465IssuerTokenRqstrAttribute;
	}

	public IssuerTokenRequestorAttribute removeT465IssuerTokenRqstrAttribute(
			IssuerTokenRequestorAttribute t465IssuerTokenRqstrAttribute) {
		getT465IssuerTokenRqstrAttributes().remove(
				t465IssuerTokenRqstrAttribute);
		t465IssuerTokenRqstrAttribute.setT463TokenRequestorAttribute(null);

		return t465IssuerTokenRqstrAttribute;
	}

	/**
	 * @return the guidRequired
	 */
	@Column(name = "IS_GUID_REQUIRED")
	public Boolean getGuidRequired() {
		return guidRequired;
	}

	/**
	 * @param guidRequired the guidRequired to set
	 */
	public void setGuidRequired(Boolean guidRequired) {
		this.guidRequired = guidRequired;
	}
}