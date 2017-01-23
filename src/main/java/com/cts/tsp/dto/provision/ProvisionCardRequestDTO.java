/**
 * 
 */
package com.cts.tsp.dto.provision;

/**
 * @author administrator
 *
 */
public class ProvisionCardRequestDTO {
	private String deviceId;
	private CardInfo cardInfo;
	private String productType;
	private String requestor;
	private String aid;
	private String aidVersion;
	private String deviceLanguage;
	private String panSource;
	
	/**
	 * @return the deviceId
	 */
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
	 * @return the cardInfo
	 */
	public CardInfo getCardInfo() {
		return cardInfo;
	}
	/**
	 * @param cardInfo the cardInfo to set
	 */
	public void setCardInfo(CardInfo cardInfo) {
		this.cardInfo = cardInfo;
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
	 * @return the panSource
	 */
	public String getPanSource() {
		return panSource;
	}
	/**
	 * @param panSource the panSource to set
	 */
	public void setPanSource(String panSource) {
		this.panSource = panSource;
	}
}
