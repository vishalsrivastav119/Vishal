/**
 * 
 */
package com.cts.tsp.dto.provision;

import java.util.Date;

/**
 * @author administrator
 *
 */
public class CardInfo {
	private String pan;
	private Date panExpiryDate;
	private String psn;
	private String cvv;
	/**
	 * @return the pan
	 */
	public String getPan() {
		return pan;
	}
	/**
	 * @param pan the pan to set
	 */
	public void setPan(String pan) {
		this.pan = pan;
	}
	/**
	 * @return the panExpiryDate
	 */
	public Date getPanExpiryDate() {
		return panExpiryDate;
	}
	/**
	 * @param panExpiryDate the panExpiryDate to set
	 */
	public void setPanExpiryDate(Date panExpiryDate) {
		this.panExpiryDate = panExpiryDate;
	}
	/**
	 * @return the psn
	 */
	public String getPsn() {
		return psn;
	}
	/**
	 * @param psn the psn to set
	 */
	public void setPsn(String psn) {
		this.psn = psn;
	}
	/**
	 * @return the cvv
	 */
	public String getCvv() {
		return cvv;
	}
	/**
	 * @param cvv the cvv to set
	 */
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
}
