/**
 * 
 */
package com.cts.tsp.service.message;

/**
 * @author Somnath
 *
 */
public interface ResponseMessageService {

	public String getResponseMessage(String requestorId,String code);
	public String getResponseMessage(String code);
}
