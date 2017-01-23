/**
 * 
 */
package com.cts.tsp.dao.message;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cts.tsp.dao.GenericDAOImpl;
import com.cts.tsp.domain.ResponseMessageConfig;

/**
 * @author Somnath
 *
 */
@Repository
public class ResponseMessageConfigDAOImpl extends
		GenericDAOImpl<ResponseMessageConfig, String> implements
		ResponseMessageConfigDAO {
	
	public ResponseMessageConfig getReponseConfigByCode(String code){
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("code", code);
		return this.queryForObject("ResponseMessageConfig.getByCode", parameters);	
	}
}
