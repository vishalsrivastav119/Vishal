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
 * The persistent class for the t_473_mobile_device_token_reg_info database table.
 * 
 */
@Entity
@Table(name="t_473_mobile_device_token_reg_info")
@NamedQuery(name="MobileDeviceTokenRegistrationInfo.findAll", query="SELECT m FROM MobileDeviceTokenRegistrationInfo m")
public class MobileDeviceTokenRegistrationInfo extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private String recordId;
	private String isTokenRegd;
	private String mobileDeviceTokenRegGuiId;
	private String tokenPan;
	private MobileDeviceRegistrationInfo t472MobileDeviceRegInfo;

	public MobileDeviceTokenRegistrationInfo() {
	}


	@Id
	@Column(name="RECORD_ID")
	public String getRecordId() {
		return this.recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}




	@Column(name="IS_TOKEN_REGD")
	public String getIsTokenRegd() {
		return this.isTokenRegd;
	}

	public void setIsTokenRegd(String isTokenRegd) {
		this.isTokenRegd = isTokenRegd;
	}


	@Column(name="MOBILE_DEVICE_TOKEN_REG_GUI_ID")
	public String getMobileDeviceTokenRegGuiId() {
		return this.mobileDeviceTokenRegGuiId;
	}

	public void setMobileDeviceTokenRegGuiId(String mobileDeviceTokenRegGuiId) {
		this.mobileDeviceTokenRegGuiId = mobileDeviceTokenRegGuiId;
	}




	@Column(name="TOKEN_PAN")
	public String getTokenPan() {
		return this.tokenPan;
	}

	public void setTokenPan(String tokenPan) {
		this.tokenPan = tokenPan;
	}


	//bi-directional many-to-one association to MobileDeviceRegistrationInfo
	@ManyToOne
	@JoinColumn(name="MOBILE_DEVICE_REG")
	public MobileDeviceRegistrationInfo getT472MobileDeviceRegInfo() {
		return this.t472MobileDeviceRegInfo;
	}

	public void setT472MobileDeviceRegInfo(MobileDeviceRegistrationInfo t472MobileDeviceRegInfo) {
		this.t472MobileDeviceRegInfo = t472MobileDeviceRegInfo;
	}

}