package com.cts.tsp.rest.issuer;

import com.cts.tsp.domain.Issuer;
import com.cts.tsp.dto.PaginatedList;

public interface IssuerAPI {
	public PaginatedList<Issuer> getIssuersByPage(Integer limit, Integer offset);
	
	public Issuer getIssuer(String id);
	
	public Issuer updateIssuer(String id, Issuer issuer);
	
	public Issuer addIssuer(Issuer issuer);
}
