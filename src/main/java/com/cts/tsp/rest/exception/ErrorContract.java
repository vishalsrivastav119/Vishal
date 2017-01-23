/**
 * 
 */
package com.cts.tsp.rest.exception;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import com.cts.tsp.exception.ApplicationException;
import com.cts.tsp.exception.ErrorCode;

/**
 * @author 111033
 *
 */
public class ErrorContract implements Serializable{
	private static final long serialVersionUID = 1L;

	private ErrorCode errorCode;
	private String context;
	private String message;
	
	
	
	/**
	 * 
	 */
	public ErrorContract(ApplicationException exception){
		try {
			BeanUtils.copyProperties(this, exception);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @return the errorCode
	 */
	public ErrorCode getErrorCode() {
		return errorCode;
	}
	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}
	/**
	 * @return the context
	 */
	public String getContext() {
		return context;
	}
	/**
	 * @param context the context to set
	 */
	public void setContext(String context) {
		this.context = context;
	}
	/**
	 * @return the errorMessage
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setMessage(String errorMessage) {
		this.message = errorMessage;
	}
}