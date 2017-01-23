/**
 * 
 */
package com.cts.tsp.dao.provision;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cts.tsp.dao.GenericDAOImpl;
import com.cts.tsp.domain.TokenProvisionRequestQueue;

/**
 * @author Somnath
 *
 */
@Repository
public class TokenProvisionRequestQueueDAOImpl extends
		GenericDAOImpl<TokenProvisionRequestQueue, String> implements
		TokenProvisionRequestQueueDAO {

	@Override
	public List<TokenProvisionRequestQueue> getRequestQueueItemByFPan(
			String fpan) {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("fpan", fpan);
		return this.queryForList("TokenProvisionRequestQueue.getByFPan", parameters);
	}
}
