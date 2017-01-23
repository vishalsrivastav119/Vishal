/**
 * 
 */
package com.cts.tsp.dao.provision;

import java.util.List;

import com.cts.tsp.dao.GenericDAO;
import com.cts.tsp.domain.TokenPool;

/**
 * @author Somnath 
 *
 */
public interface TokenPoolDAO extends GenericDAO<TokenPool, Long> {
	public List<TokenPool> getActiveTokens(String tokenBin);
}
