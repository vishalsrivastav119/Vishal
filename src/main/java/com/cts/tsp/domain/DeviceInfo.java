package com.cts.tsp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cts.tsp.domain.enumerations.DeviceStatus;
import com.cts.tsp.rest.config.Views;
import com.fasterxml.jackson.annotation.JsonView;


/**
 * The persistent class for the t_454_issuer database table.
 * 
 */
@Entity
@Table(name="device_info")
public class DeviceInfo extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private String deviceId;
	private String msisdn;
	private String make;
	private String model;
	private String sdkVersion;
	private String imei;
	private DeviceStatus status;
	private CustomerInfo customerInfo;
	
	/**
	 * @return the deviceId
	 */
	@Id
	@Column(name="device_id")
	public String getDeviceId() {
		return deviceId;
	}
	/**
	 * @param deviceId the deviceId to set
	 */
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	/**
	 * @return the msisdn
	 */
	@Column(name="msisdn")
	public String getMsisdn() {
		return msisdn;
	}
	/**
	 * @param msisdn the msisdn to set
	 */
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	/**
	 * @return the make
	 */
	@Column(name="make")
	public String getMake() {
		return make;
	}
	/**
	 * @param make the make to set
	 */
	public void setMake(String make) {
		this.make = make;
	}
	/**
	 * @return the model
	 */
	@Column(name="model")
	public String getModel() {
		return model;
	}
	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}
	/**
	 * @return the sdkVersion
	 */
	@Column(name="sdkversion")
	public String getSdkVersion() {
		return sdkVersion;
	}
	/**
	 * @param sdkVersion the sdkVersion to set
	 */
	public void setSdkVersion(String sdkVersion) {
		this.sdkVersion = sdkVersion;
	}
	/**
	 * @return the imei
	 */
	@Column(name="imei")
	public String getImei() {
		return imei;
	}
	/**
	 * @param imei the imei to set
	 */
	public void setImei(String imei) {
		this.imei = imei;
	}
	/**
	 * @return the status
	 */
	@Enumerated
	@Column(name="status")
	public DeviceStatus getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(DeviceStatus status) {
		this.status = status;
	}
	/**
	 * @return the customerInfo
	 */
	@JsonView(Views.InternalView.class)
	@ManyToOne
	@JoinColumn(name="customer_id", referencedColumnName="customer_id")
	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}
	/**
	 * @param customerInfo the customerInfo to set
	 */
	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}
}