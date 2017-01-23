/**
 * 
 */
package com.cts.tsp.dto.device;

/**
 * @author administrator
 *
 */
public class RegisterDeviceRequestDTO {
	private String activationCode;
	private String make;
	private String model;
	private String imei;
	private String msisdn;
	private String sdkVersion;
	
	/**
	 * @return the sdkVersion
	 */
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
	 * @return the activationCode
	 */
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
	 * @return the make
	 */
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
	 * @return the imei
	 */
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
	 * @return the msisdn
	 */
	public String getMsisdn() {
		return msisdn;
	}
	/**
	 * @param msisdn the msisdn to set
	 */
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
}
