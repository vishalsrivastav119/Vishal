/**
 * 
 */
package com.cts.tsp.rest.issuer;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cts.tsp.domain.Issuer;
import com.cts.tsp.dto.PaginatedList;
import com.cts.tsp.service.issuer.IssuerService;

/**
 * @author root
 *
 */
@Component
@Path("/v1/issuers")
public class IssuerAPIImpl implements IssuerAPI {

	@Autowired
	private IssuerService issuerService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public PaginatedList<Issuer> getIssuersByPage(@QueryParam("limit") Integer limit,@QueryParam("offset")  Integer offset) {
		return issuerService.getIssuersByPage(limit, offset);
	}

	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Issuer getIssuer(@PathParam("id") String id) {
		return issuerService.getIssuer(id);
	}

	@Path("{id}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Issuer updateIssuer(@PathParam("id") String id, Issuer issuer) {
		return issuerService.updateIssuer(id, issuer);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Issuer addIssuer(Issuer issuer) {
		return issuerService.addIssuer(issuer);
	}

}
