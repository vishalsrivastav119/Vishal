/**
 * 
 */
package com.cts.tsp.dao.issuer;

import com.cts.tsp.dao.GenericDAO;
import com.cts.tsp.domain.ProductType;

/**
 * @author Somnath
 *
 */
public interface ProductTypeDAO extends GenericDAO<ProductType, String>{
	public ProductType getProductTypeByName(String name);
}
