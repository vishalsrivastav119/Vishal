/**
 * 
 */
package com.cts.tsp.dao.issuer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cts.tsp.dao.GenericDAOImpl;
import com.cts.tsp.domain.IssuerProductType;

/**
 * @author Somnath
 * 
 */
@Repository
public class IssuerProductTypeDAOImpl extends
		GenericDAOImpl<IssuerProductType, String> implements
		IssuerProductTypeDAO {
	public 	IssuerProductType findIssuerProductTypeByProductType(String productType){
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("productType", productType);
		return this.queryForObject("IssuerProductType.findByProductType", parameters);
	}
}
