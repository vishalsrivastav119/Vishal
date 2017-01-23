/**
 * 
 */
package com.cts.tsp.service.issuer;

import java.util.List;

import com.cts.tsp.domain.Issuer;
import com.cts.tsp.dto.PaginatedList;

/**
 * @author Somnath
 *
 */
public interface IssuerService {
	public List<Issuer> getIssuers();
	
	public PaginatedList<Issuer> getIssuersByPage(Integer limit, Integer offset);
	
	public Issuer getIssuer(String id);
	
	public Issuer updateIssuer(String id, Issuer issuer);
	
	public Issuer addIssuer(Issuer issuer);
}