/**
 * 
 */
package com.cts.tsp.dto.provision;


/**
 * @author Somnath
 *
 */
public class NetworkCheckCardResponseDTO {
	public String nextStepToken;
	public Long nextStepTokenTTL;
	public String fPANId;
	public String dPANId;
	public String fPANReference;
	
	public String getNextStepToken() {
		return nextStepToken;
	}
	public void setNextStepToken(String nextStepToken) {
		this.nextStepToken = nextStepToken;
	}
	public Long getNextStepTokenTTL() {
		return nextStepTokenTTL;
	}
	public void setNextStepTokenTTL(Long nextStepTokenTTL) {
		this.nextStepTokenTTL = nextStepTokenTTL;
	}
	public String getfPANId() {
		return fPANId;
	}
	public void setfPANId(String fPANId) {
		this.fPANId = fPANId;
	}
	public String getdPANId() {
		return dPANId;
	}
	public void setdPANId(String dPANId) {
		this.dPANId = dPANId;
	}
	public String getfPANReference() {
		return fPANReference;
	}
	public void setfPANReference(String fPANReference) {
		this.fPANReference = fPANReference;
	}
	public String getdPANReference() {
		return dPANReference;
	}
	public void setdPANReference(String dPANReference) {
		this.dPANReference = dPANReference;
	}
	public String dPANReference;
	
}
