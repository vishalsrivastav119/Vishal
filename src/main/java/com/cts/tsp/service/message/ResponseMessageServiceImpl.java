/**
 * 
 */
package com.cts.tsp.service.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.tsp.dao.message.ResponseMessageConfigDAO;
import com.cts.tsp.dao.message.TokenReqestorResponseMessageConfigDAO;
import com.cts.tsp.domain.ResponseMessageConfig;
import com.cts.tsp.domain.TokenReqestorResponseMessageConfig;

/**
 * @author Somnath
 *
 */
@Service
public class ResponseMessageServiceImpl implements ResponseMessageService {
	@Autowired
	private TokenReqestorResponseMessageConfigDAO tokenReqestorResponseMessageConfigDAO;

	@Autowired
	private ResponseMessageConfigDAO responseMessageConfigDAO;
	
	public String getResponseMessage(String requestorId,String code){
		if(requestorId == null || "".equals(requestorId)){
			return getResponseMessage(code);
		}
		TokenReqestorResponseMessageConfig messageConfig = tokenReqestorResponseMessageConfigDAO.getMessageByCode(requestorId, code);
		if(messageConfig == null){
			return "UNKNOWN ERROR";
		}else{
			return messageConfig.getRespMessageCfgValue();
		}
	}
	
	public String getResponseMessage(String code){
		ResponseMessageConfig messageConfig = responseMessageConfigDAO.getReponseConfigByCode(code);
		if(messageConfig == null){
			return "UNKNOWN ERROR";
		}else{
			return messageConfig.getRespMessageCfgValue();
		}
	}
}
