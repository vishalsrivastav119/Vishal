/**
 * 
 */
package com.cts.tsp.dto.provision;

/**
 * @author Somnath
 *
 */
public class ProvisionRequestContentDTO {
	private String attributeName;
	private String GUID;
	/**
	 * @return the attributeName
	 */
	public String getAttributeName() {
		return attributeName;
	}
	/**
	 * @param attributeName the attributeName to set
	 */
	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}
	/**
	 * @return the gUID
	 */
	public String getGUID() {
		return GUID;
	}
	/**
	 * @param gUID the gUID to set
	 */
	public void setGUID(String gUID) {
		GUID = gUID;
	}
	
}
