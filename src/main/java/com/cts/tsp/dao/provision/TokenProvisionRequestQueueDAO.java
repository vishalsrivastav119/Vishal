/**
 * 
 */
package com.cts.tsp.dao.provision;

import java.util.List;

import com.cts.tsp.dao.GenericDAO;
import com.cts.tsp.domain.TokenProvisionRequestQueue;

/**
 * @author Somnath
 *
 */
public interface TokenProvisionRequestQueueDAO extends
		GenericDAO<TokenProvisionRequestQueue, String> {
	public List<TokenProvisionRequestQueue> getRequestQueueItemByFPan(
			String fpan);
}
