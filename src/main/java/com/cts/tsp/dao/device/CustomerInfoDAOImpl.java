/**
 * 
 */
package com.cts.tsp.dao.device;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cts.tsp.dao.GenericDAOImpl;
import com.cts.tsp.domain.CustomerInfo;

/**
 * @author administrator
 *
 */
@Repository
public class CustomerInfoDAOImpl extends GenericDAOImpl<CustomerInfo, String> implements CustomerInfoDAO {
	
	@Override
	public CustomerInfo getByActivationCode(String activationCode){
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("activationCode", activationCode);
		parameterMap.put("expiryDate", new Timestamp(System.currentTimeMillis()));
		return queryForObject("CustomerInfo.getByActivationCode", parameterMap);
	}
}
