/**
 * 
 */
package com.cts.tsp.dto.provision;

import com.cts.tsp.domain.enumerations.ProvisionStatus;

/**
 * @author administrator
 *
 */
public class ProvisionCardResponseDTO {
	private String provisionId;
	private ProvisionStatus status;
	private String nextStepToken;
	private String token;
	private Long nextStepTokenTTL;
	
	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}
	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}
	
	/**
	 * @return the nextStepTokenTTL
	 */
	public Long getNextStepTokenTTL() {
		return nextStepTokenTTL;
	}
	/**
	 * @param nextStepTokenTTL the nextStepTokenTTL to set
	 */
	public void setNextStepTokenTTL(Long nextStepTokenTTL) {
		this.nextStepTokenTTL = nextStepTokenTTL;
	}
	/**
	 * @return the provisionId
	 */
	public String getProvisionId() {
		return provisionId;
	}
	/**
	 * @param provisionId the provisionId to set
	 */
	public void setProvisionId(String provisionId) {
		this.provisionId = provisionId;
	}
	/**
	 * @return the status
	 */
	public ProvisionStatus getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(ProvisionStatus status) {
		this.status = status;
	}
	/**
	 * @return the nextStepToken
	 */
	public String getNextStepToken() {
		return nextStepToken;
	}
	/**
	 * @param nextStepToken the nextStepToken to set
	 */
	public void setNextStepToken(String nextStepToken) {
		this.nextStepToken = nextStepToken;
	}
		
}
