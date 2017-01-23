/**
 * 
 */
package com.cts.tsp.dao.issuer;

import com.cts.tsp.dao.GenericDAO;
import com.cts.tsp.domain.IssuerProductType;

/**
 * @author Somnath
 *
 */
public interface IssuerProductTypeDAO extends
		GenericDAO<IssuerProductType, String> {

	public 	IssuerProductType findIssuerProductTypeByProductType(String productType);
}
