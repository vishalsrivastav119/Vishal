/**
 * 
 */
package com.cts.tsp.dao.message;

import com.cts.tsp.dao.GenericDAO;
import com.cts.tsp.domain.ResponseMessageConfig;

/**
 * @author Somnath
 *
 */
public interface ResponseMessageConfigDAO extends
		GenericDAO<ResponseMessageConfig, String> {

	public ResponseMessageConfig getReponseConfigByCode(String code);
}
