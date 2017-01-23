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
 * The persistent class for the t_472_mobile_device_reg_info database table.
 * 
 */
@Entity
@Table(name="t_472_mobile_device_reg_info")
@NamedQuery(name="MobileDeviceRegistrationInfo.findAll", query="SELECT m FROM MobileDeviceRegistrationInfo m")
public class MobileDeviceRegistrationInfo extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private String recordId;
	private String authToken;
	private String isDeviceRegd;
	private String mobileDeviceRegGuiId;
	private String secElmId;
	private String serviceTranInfo;
	private List<MobileDeviceTokenRegistrationInfo> t473MobileDeviceTokenRegInfos;

	public MobileDeviceRegistrationInfo() {
	}


	@Id
	@Column(name="RECORD_ID")
	public String getRecordId() {
		return this.recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}


	@Column(name="AUTH_TOKEN")
	public String getAuthToken() {
		return this.authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}



	@Column(name="IS_DEVICE_REGD")
	public String getIsDeviceRegd() {
		return this.isDeviceRegd;
	}

	public void setIsDeviceRegd(String isDeviceRegd) {
		this.isDeviceRegd = isDeviceRegd;
	}


	@Column(name="MOBILE_DEVICE_REG_GUI_ID")
	public String getMobileDeviceRegGuiId() {
		return this.mobileDeviceRegGuiId;
	}

	public void setMobileDeviceRegGuiId(String mobileDeviceRegGuiId) {
		this.mobileDeviceRegGuiId = mobileDeviceRegGuiId;
	}


	@Column(name="SEC_ELM_ID")
	public String getSecElmId() {
		return this.secElmId;
	}

	public void setSecElmId(String secElmId) {
		this.secElmId = secElmId;
	}


	@Column(name="SERVICE_TRAN_INFO")
	public String getServiceTranInfo() {
		return this.serviceTranInfo;
	}

	public void setServiceTranInfo(String serviceTranInfo) {
		this.serviceTranInfo = serviceTranInfo;
	}


	//bi-directional many-to-one association to MobileDeviceTokenRegistrationInfo
	@OneToMany(mappedBy="t472MobileDeviceRegInfo")
	public List<MobileDeviceTokenRegistrationInfo> getT473MobileDeviceTokenRegInfos() {
		return this.t473MobileDeviceTokenRegInfos;
	}

	public void setT473MobileDeviceTokenRegInfos(List<MobileDeviceTokenRegistrationInfo> t473MobileDeviceTokenRegInfos) {
		this.t473MobileDeviceTokenRegInfos = t473MobileDeviceTokenRegInfos;
	}

	public MobileDeviceTokenRegistrationInfo addT473MobileDeviceTokenRegInfo(MobileDeviceTokenRegistrationInfo t473MobileDeviceTokenRegInfo) {
		getT473MobileDeviceTokenRegInfos().add(t473MobileDeviceTokenRegInfo);
		t473MobileDeviceTokenRegInfo.setT472MobileDeviceRegInfo(this);

		return t473MobileDeviceTokenRegInfo;
	}

	public MobileDeviceTokenRegistrationInfo removeT473MobileDeviceTokenRegInfo(MobileDeviceTokenRegistrationInfo t473MobileDeviceTokenRegInfo) {
		getT473MobileDeviceTokenRegInfos().remove(t473MobileDeviceTokenRegInfo);
		t473MobileDeviceTokenRegInfo.setT472MobileDeviceRegInfo(null);

		return t473MobileDeviceTokenRegInfo;
	}

}