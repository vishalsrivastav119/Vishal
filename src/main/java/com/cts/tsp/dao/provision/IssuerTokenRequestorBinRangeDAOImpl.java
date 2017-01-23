/**
 * 
 */
package com.cts.tsp.dao.provision;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cts.tsp.dao.GenericDAOImpl;
import com.cts.tsp.domain.IssuerTokenRequestorTokenBinRange;

/**
 * @author Somnath
 *
 */
@Repository
public class IssuerTokenRequestorBinRangeDAOImpl extends
		GenericDAOImpl<IssuerTokenRequestorTokenBinRange, String> implements
		IssuerTokenRequestorBinRangeDAO {
	
	public IssuerTokenRequestorTokenBinRange findTokenBinRangeByRequestor(String requestorId){
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("requestorId", requestorId);
		return this.queryForObject("IssuerTokenRequestorTokenBinRange.findByRequestor", parameters);
	}
}