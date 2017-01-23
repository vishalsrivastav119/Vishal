/**
 * 
 */
package com.cts.tsp.dao.message;

import com.cts.tsp.dao.GenericDAO;
import com.cts.tsp.domain.TokenReqestorResponseMessageConfig;

/**
 * @author Somnath
 *
 */
public interface TokenReqestorResponseMessageConfigDAO extends
		GenericDAO<TokenReqestorResponseMessageConfig, String> {
	public TokenReqestorResponseMessageConfig getMessageByCode(String requestorId, String messageCode);
	
}
