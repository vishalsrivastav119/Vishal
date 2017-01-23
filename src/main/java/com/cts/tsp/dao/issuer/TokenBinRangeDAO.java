/**
 * 
 */
package com.cts.tsp.dao.issuer;

import com.cts.tsp.dao.GenericDAO;
import com.cts.tsp.domain.FundingBinRange;
import com.cts.tsp.domain.TokenBinRange;

/**
 * @author Somnath
 *
 */
public interface TokenBinRangeDAO extends GenericDAO<TokenBinRange, String> {
	public TokenBinRange findByFundingPrefix(String fundingPrefix);
}
