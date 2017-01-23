/**
 * 
 */
package com.cts.tsp.dao.provision;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cts.tsp.dao.GenericDAOImpl;
import com.cts.tsp.domain.TokenPool;
import com.cts.tsp.domain.TokenStatus;

/**
 * @author Somnath
 *
 */
@Repository
public class TokenPoolDAOImpl extends GenericDAOImpl<TokenPool, Long> implements
		TokenPoolDAO {
	@Override
	public List<TokenPool> getActiveTokens(String tokenBin){
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("status", TokenStatus.CREATED);
		parameterMap.put("tokenBin", tokenBin);
		return queryForList("TokenPool.findByStatus", parameterMap);
	}
}
