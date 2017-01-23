/**
 * 
 */
package com.cts.tsp.dao.issuer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cts.tsp.dao.GenericDAOImpl;
import com.cts.tsp.domain.TokenBinRange;

/**
 * @author Somnath
 * 
 */
@Repository
public class TokenBinRangeDAOImpl extends GenericDAOImpl<TokenBinRange, String>
		implements TokenBinRangeDAO {

	public TokenBinRange findByFundingPrefix(String fundingPrefix) {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("fundingPrefix", fundingPrefix);
		return this.queryForObject("TokenBinRange.findByPrefix", parameters);
	}
}
