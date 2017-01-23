/**
 * 
 */
package com.cts.tsp.rest.provision;

import com.cts.tsp.dto.provision.NetworkCheckCardRequestDTO;
import com.cts.tsp.dto.provision.NetworkCheckCardResponseDTO;
import com.cts.tsp.dto.provision.ProvisionCardRequestDTO;
import com.cts.tsp.dto.provision.ProvisionCardResponseDTO;

/**
 * @author Somnath
 *
 */
public interface ProvisionAPI {
	public NetworkCheckCardResponseDTO networkCheckCard(NetworkCheckCardRequestDTO request);

	public ProvisionCardResponseDTO provisionCard(ProvisionCardRequestDTO request);
}
