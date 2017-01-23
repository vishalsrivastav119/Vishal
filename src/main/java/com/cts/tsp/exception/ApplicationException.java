/**
 * 
 */
package com.cts.tsp.exception;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author 111033
 *
 */
public class ApplicationException extends RuntimeException implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String context;
	private ErrorCode errorCode;
	private Map<String,String> contextMap = new HashMap<String, String>();
	private String friendlyMessage;
	
	
	
	/**
	 * @param message
	 * @param cause
	 */
	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
		context = getRandomContext();
	}

	/**
	 * @param message
	 */
	public ApplicationException(String message) {
		super(message);
		context = getRandomContext();
	}

	/**
	 * @param message
	 */
	public ApplicationException(ErrorCode errorCode) {
		super();
		this.errorCode = errorCode;
		context = getRandomContext();
	}
	
	/**
	 * @param cause
	 */
	public ApplicationException(Throwable cause) {
		super(cause);
		context = getRandomContext();
	}
	
	private String getRandomContext(){
		return String.valueOf(UUID.randomUUID().getMostSignificantBits());
	}

	/**
	 * @return
	 */
	public String getContext() {
		return context;
	}

	/**
	 * @return
	 */
	public ErrorCode getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode
	 */
	public void setErrorCode(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the contextMap
	 */
	public Map<String, String> getContextMap() {
		return contextMap;
	}

	/**
	 * @param contextMap the contextMap to set
	 */
	public void setContextMap(Map<String, String> contextMap) {
		this.contextMap = contextMap;
	}

	/**
	 * @return the friendlyMessage
	 */
	public String getFriendlyMessage() {
		return friendlyMessage;
	}

	/**
	 * @param friendlyMessage the friendlyMessage to set
	 */
	public void setFriendlyMessage(String friendlyMessage) {
		this.friendlyMessage = friendlyMessage;
	}
	
	public String getMessage(){
		if(this.friendlyMessage!=null){
			return friendlyMessage;
		}
		return super.getMessage();
	}
}
