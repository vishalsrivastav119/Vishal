/**
 * 
 */
package com.cts.tsp.dao.provision;

import com.cts.tsp.dao.GenericDAO;
import com.cts.tsp.domain.TokenPrefixCounter;

/**
 * @author Somnath
 *
 */
public interface TokenPrefixCounterDAO extends GenericDAO<TokenPrefixCounter, String>{
	public TokenPrefixCounter getCounterByTokenPrefix(String tokenPrefix);
	

}
