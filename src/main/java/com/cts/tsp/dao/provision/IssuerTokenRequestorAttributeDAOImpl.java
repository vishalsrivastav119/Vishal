/**
 * 
 */
package com.cts.tsp.dao.provision;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cts.tsp.dao.GenericDAOImpl;
import com.cts.tsp.domain.IssuerTokenRequestorAttribute;

/**
 * @author Somnath
 *
 */
@Repository
public class IssuerTokenRequestorAttributeDAOImpl extends GenericDAOImpl<IssuerTokenRequestorAttribute, String>
		implements IssuerTokenRequestorAttributeDAO {
	public List<IssuerTokenRequestorAttribute> findAllAttributesForRequestor(String requestorId){
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("requestorId", requestorId);
		return this.queryForList("IssuerTokenRequestorAttribute.findByRequestor", parameters);
	}
	
}
