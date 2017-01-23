/**
 * 
 */
package com.cts.tsp.dao.issuer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cts.tsp.dao.GenericDAOImpl;
import com.cts.tsp.domain.FundingBinRange;

/**
 * @author Somnath
 *
 */
@Repository
public class FundingBinRangeDAOImpl extends
		GenericDAOImpl<FundingBinRange, String> implements FundingBinRangeDAO {
	
	public FundingBinRange findByFundingPrefix(String fundingPrefix){
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("fundingPrefix", fundingPrefix);
		return this.queryForObject("FundingBinRange.findByPrefix", parameters);
	}
}
