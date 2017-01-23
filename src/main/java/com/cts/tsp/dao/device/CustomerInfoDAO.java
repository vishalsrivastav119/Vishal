/**
 * 
 */
package com.cts.tsp.dao.device;

import com.cts.tsp.dao.GenericDAO;
import com.cts.tsp.domain.CustomerInfo;

/**
 * @author administrator
 *
 */
public interface CustomerInfoDAO extends GenericDAO<CustomerInfo, String>{
	public CustomerInfo getByActivationCode(String activationCode);
}
