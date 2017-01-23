package com.cts.tsp.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cts.tsp.exception.ApplicationException;
import com.cts.tsp.service.message.ResponseMessageService;

@Component
public class ExceptionMessageTranslator {
	private static final Logger log= LogManager.getLogger(ExceptionMessageTranslator.class);
	
	@Autowired
	private ResponseMessageService responseMessageService;
	
	public void enrichMessage(ApplicationException appException){
		System.out.println(appException.getErrorCode().toString().substring(4, appException.getErrorCode().toString().length()));
		String errorMessage= responseMessageService.getResponseMessage(appException.getContextMap().get("requestorId"), appException.getErrorCode().toString().substring(4, appException.getErrorCode().toString().length()));
		appException.setFriendlyMessage(errorMessage);
	}
}