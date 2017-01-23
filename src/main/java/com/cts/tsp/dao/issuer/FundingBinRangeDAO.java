/**
 * 
 */
package com.cts.tsp.dao.issuer;

import com.cts.tsp.dao.GenericDAO;
import com.cts.tsp.domain.FundingBinRange;

/**
 * @author Somnath
 *
 */
public interface FundingBinRangeDAO extends GenericDAO<FundingBinRange, String> {
	
	public FundingBinRange findByFundingPrefix(String fundingPrefix);
}
