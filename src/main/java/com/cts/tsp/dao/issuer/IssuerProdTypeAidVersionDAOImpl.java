/**
 * 
 */
package com.cts.tsp.dao.issuer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cts.tsp.dao.GenericDAOImpl;
import com.cts.tsp.domain.IssuerProdTypeAidVersion;

/**
 * @author Somnath
 *
 */
@Repository
public class IssuerProdTypeAidVersionDAOImpl extends
		GenericDAOImpl<IssuerProdTypeAidVersion, String> implements
		IssuerProdTypeAidVersionDAO {
	
	public List<IssuerProdTypeAidVersion> getDetailsByAID(String aid){
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("aid", aid);
		return this.queryForList("IssuerProdTypeAidVersion.findByAID", parameters);
	}
}