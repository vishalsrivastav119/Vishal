/**
 * 
 */
package com.cts.tsp.dao.message;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cts.tsp.dao.GenericDAOImpl;
import com.cts.tsp.domain.TokenReqestorResponseMessageConfig;

/**
 * @author Somnath
 *
 */
@Repository
public class TokenReqestorResponseMessageConfigDAOImpl extends
		GenericDAOImpl<TokenReqestorResponseMessageConfig, String> implements
		TokenReqestorResponseMessageConfigDAO {
	public TokenReqestorResponseMessageConfig getMessageByCode(String requestorId, String messageCode){
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("requestorId", requestorId);
		parameters.put("code", messageCode);
		return this.queryForObject("TokenReqestorResponseMessageConfig.getMessageByCode", parameters);
	}
}
