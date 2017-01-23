/**
 * 
 */
package com.cts.tsp.dao.provision;

import com.cts.tsp.dao.GenericDAO;
import com.cts.tsp.domain.IssuerTokenRequestorTokenBinRange;

/**
 * @author Somnath
 *
 */
public interface IssuerTokenRequestorBinRangeDAO extends
		GenericDAO<IssuerTokenRequestorTokenBinRange, String> {
	public IssuerTokenRequestorTokenBinRange findTokenBinRangeByRequestor(String requestorId);

}
