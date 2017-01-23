/**
 * 
 */
package com.cts.tsp.rest.provision;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cts.tsp.dto.provision.NetworkCheckCardRequestDTO;
import com.cts.tsp.dto.provision.NetworkCheckCardResponseDTO;
import com.cts.tsp.dto.provision.ProvisionCardRequestDTO;
import com.cts.tsp.dto.provision.ProvisionCardResponseDTO;
import com.cts.tsp.service.provision.ProvisionService;



/**
 * @author 111033
 * every resource within an application should represent an application entity. We will look to use the exposed domain model to te extent possible
 * Dealing with nouns
 * Read list - GET /resource/entity{s}/
 * Read One  - GET /resource/entity{s}/{entityId}
 * Update One- POST /resource/entity{s}/{entityId}
 * Insert    - PUT /resource/entity{s}
 * Delete One- DEL /resource/entity{s}/{entityId}
 * 
 * Dealing with verbs
 * use a different context root oher than /resource
 *   /api/verb e.g., /api/getReport
 */
@Component
@Path("/v1/cards")
public class ProvisionAPIImpl implements ProvisionAPI{
	
	@Autowired
	private ProvisionService provisionService;

	@Override
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public NetworkCheckCardResponseDTO networkCheckCard(
			NetworkCheckCardRequestDTO request) {
		return provisionService.networkCheckCard(request);
	}
	
	@Override
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ProvisionCardResponseDTO provisionCard(
			ProvisionCardRequestDTO request) { 
		return provisionService.provisionCard(request);
	}
}