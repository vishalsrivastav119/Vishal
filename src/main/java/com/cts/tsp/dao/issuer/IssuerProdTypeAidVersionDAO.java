/**
 * 
 */
package com.cts.tsp.dao.issuer;

import java.util.List;

import com.cts.tsp.dao.GenericDAO;
import com.cts.tsp.domain.IssuerProdTypeAidVersion;

/**
 * @author Somnath
 *
 */
public interface IssuerProdTypeAidVersionDAO extends
		GenericDAO<IssuerProdTypeAidVersion, String> {
	public List<IssuerProdTypeAidVersion> getDetailsByAID(String aid);
}
