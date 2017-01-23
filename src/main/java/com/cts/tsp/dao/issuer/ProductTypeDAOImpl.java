/**
 * 
 */
package com.cts.tsp.dao.issuer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cts.tsp.dao.GenericDAOImpl;
import com.cts.tsp.domain.ProductType;

/**
 * @author Somnath
 *
 */
@Repository
public class ProductTypeDAOImpl extends GenericDAOImpl<ProductType, String> implements
		ProductTypeDAO {
	
	public ProductType getProductTypeByName(String name){
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("name", name);
		return this.queryForObject("ProductType.findByName", parameters);
	}
}
