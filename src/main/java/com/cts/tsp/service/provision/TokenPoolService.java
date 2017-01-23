/**
 * 
 */
package com.cts.tsp.service.provision;

/**
 * @author Somnath
 *
 */
public interface TokenPoolService {
	public void replenishToken(String tokenBin);
	public String assignToken(String tokenBin);
}
