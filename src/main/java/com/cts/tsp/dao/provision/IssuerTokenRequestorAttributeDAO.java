/**
 * 
 */
package com.cts.tsp.dao.provision;

import java.util.List;

import com.cts.tsp.dao.GenericDAO;
import com.cts.tsp.domain.IssuerTokenRequestorAttribute;

/**
 * @author Somnath
 *
 */
public interface IssuerTokenRequestorAttributeDAO extends GenericDAO<IssuerTokenRequestorAttribute, String> {
	public List<IssuerTokenRequestorAttribute> findAllAttributesForRequestor(String requestorId);
}
