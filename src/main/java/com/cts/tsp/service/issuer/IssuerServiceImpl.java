/**
 * 
 */
package com.cts.tsp.service.issuer;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.tsp.dao.issuer.IssuerDAO;
import com.cts.tsp.domain.Issuer;
import com.cts.tsp.dto.PaginatedList;

/**
 * @author Somnath
 *
 */
@Transactional
@Service
public class IssuerServiceImpl implements IssuerService {

	@Autowired
	private IssuerDAO issuerDAO; 
	
	@Override
	public List<Issuer> getIssuers() {
		return issuerDAO.findAll();
	}
	

	public PaginatedList<Issuer> getIssuersByPage(Integer limit, Integer offset){
		return issuerDAO.queryForPaginatedList("Issuer.paginatedlist", new HashMap<String, Object>(), offset, limit);
	}
	
	public Issuer getIssuer(String id){
		return issuerDAO.find(id);
	}
	
	public Issuer updateIssuer(String id, Issuer issuer){
		return issuerDAO.update(issuer);
	}
	
	public Issuer addIssuer(Issuer issuer){
		return issuerDAO.create(issuer);
	}
}
