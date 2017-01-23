/**
 * 
 */
package com.cts.tsp.rest.device;

import com.cts.tsp.domain.DeviceInfo;
import com.cts.tsp.dto.device.RegisterDeviceRequestDTO;

/**
 * @author administrator
 *
 */
public interface DeviceAPI {
	public DeviceInfo registerDevice(RegisterDeviceRequestDTO deviceInfoDTO);
	public DeviceInfo updateRegistration(String deviceId, Integer registrationFlag);
}
