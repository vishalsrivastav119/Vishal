/**
 * 
 */
package com.cts.tsp.dao.provision;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cts.tsp.dao.GenericDAOImpl;
import com.cts.tsp.domain.TokenPrefixCounter;

/**
 * @author Somnath
 *
 */
@Repository
public class TokenPrefixCounterDAOImpl extends
		GenericDAOImpl<TokenPrefixCounter, String> implements
		TokenPrefixCounterDAO {
	
	public TokenPrefixCounter getCounterByTokenPrefix(String tokenPrefix){
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("tokenPrefix", tokenPrefix);
		return this.queryForObject("TokenPrefixCounter.getCounterByTokenPrefix", parameters);	
	}
}
