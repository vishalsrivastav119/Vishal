package com.cts.tsp.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the t_454_issuer database table.
 * 
 */
@Entity
@Table(name="customer_info")
public class CustomerInfo extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private String customerId;
	private String activationCode;
	private Timestamp expiryDate;
	private Issuer issuer;
	
	
	/**
	 * @return the customerId
	 */
	@Id
	@Column(name="customer_id", length=14)
	public String getCustomerId() {
		return customerId;
	}


	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}


	/**
	 * @return the activationCode
	 */
	@Column(name="activation_Code")
	public String getActivationCode() {
		return activationCode;
	}


	/**
	 * @param activationCode the activationCode to set
	 */
	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}


	/**
	 * @return the expiryDate
	 */
	@Column(name="expiry_date")
	public Timestamp getExpiryDate() {
		return expiryDate;
	}


	/**
	 * @param expiryDate the expiryDate to set
	 */
	public void setExpiryDate(Timestamp expiryDate) {
		this.expiryDate = expiryDate;
	}


	/**
	 * @return the issuer
	 */
	@ManyToOne
	@JoinColumn(name="issuer_id",referencedColumnName="record_id")
	public Issuer getIssuer() {
		return issuer;
	}


	/**
	 * @param issuer the issuer to set
	 */
	public void setIssuer(Issuer issuer) {
		this.issuer = issuer;
	}
}