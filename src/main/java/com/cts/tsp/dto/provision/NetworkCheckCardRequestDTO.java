/**
 * 
 */
package com.cts.tsp.dto.provision;

import java.util.Date;

/**
 * @author Somnath
 *
 */
public class NetworkCheckCardRequestDTO {
	private String fundingPan;
	private String fundingPanId;
	private Date panExpiryDate;
	private String deviceSecureElementId;
	private String fPanSource;
	private String deviceLanguage;
	private String includeCardInfo;
	// cross validate against requestor
	private String productType;
	private String requestor;
	private String aid;
	private String aidVersion;
	
	

	/**
	 * @return the fundingPan
	 */
	public String getFundingPan() {
		return fundingPan;
	}
	/**
	 * @param fundingPan the fundingPan to set
	 */
	public void setFundingPan(String fundingPan) {
		this.fundingPan = fundingPan;
	}
	/**
	 * @return the fundingPanId
	 */
	public String getFundingPanId() {
		return fundingPanId;
	}
	/**
	 * @param fundingPanId the fundingPanId to set
	 */
	public void setFundingPanId(String fundingPanId) {
		this.fundingPanId = fundingPanId;
	}
	/**
	 * @return the panExpriyDate
	 */
	public Date getPanExpiryDate() {
		return panExpiryDate;
	}
	/**
	 * @param panExpriyDate the panExpriyDate to set
	 */
	public void setPanExpiryDate(Date panExpiryDate) {
		this.panExpiryDate = panExpiryDate;
	}
	/**
	 * @return the deviceSecureElementId
	 */
	public String getDeviceSecureElementId() {
		return deviceSecureElementId;
	}
	/**
	 * @param deviceSecureElementId the deviceSecureElementId to set
	 */
	public void setDeviceSecureElementId(String deviceSecureElementId) {
		this.deviceSecureElementId = deviceSecureElementId;
	}
	/**
	 * @return the fPanSource
	 */
	public String getfPanSource() {
		return fPanSource;
	}
	/**
	 * @param fPanSource the fPanSource to set
	 */
	public void setfPanSource(String fPanSource) {
		this.fPanSource = fPanSource;
	}
	/**
	 * @return the deviceLanguage
	 */
	public String getDeviceLanguage() {
		return deviceLanguage;
	}
	/**
	 * @param deviceLanguage the deviceLanguage to set
	 */
	public void setDeviceLanguage(String deviceLanguage) {
		this.deviceLanguage = deviceLanguage;
	}
	/**
	 * @return the includeCardInfo
	 */
	public String getIncludeCardInfo() {
		return includeCardInfo;
	}
	/**
	 * @param includeCardInfo the includeCardInfo to set
	 */
	public void setIncludeCardInfo(String includeCardInfo) {
		this.includeCardInfo = includeCardInfo;
	}
	
	/**
	 * @return the productType
	 */
	public String getProductType() {
		return productType;
	}
	/**
	 * @param productType the productType to set
	 */
	public void setProductType(String productType) {
		this.productType = productType;
	}
	/**
	 * @return the requestor
	 */
	public String getRequestor() {
		return requestor;
	}
	/**
	 * @param requestor the requestor to set
	 */
	public void setRequestor(String requestor) {
		this.requestor = requestor;
	}
	/**
	 * @return the aid
	 */
	public String getAid() {
		return aid;
	}
	/**
	 * @param aid the aid to set
	 */
	public void setAid(String aid) {
		this.aid = aid;
	}
	/**
	 * @return the aidVersion
	 */
	public String getAidVersion() {
		return aidVersion;
	}
	/**
	 * @param aidVersion the aidVersion to set
	 */
	public void setAidVersion(String aidVersion) {
		this.aidVersion = aidVersion;
	}
}
