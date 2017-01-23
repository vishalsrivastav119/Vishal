/**
 * 
 */
package com.cts.tsp.service.device;

import com.cts.tsp.domain.DeviceInfo;
import com.cts.tsp.dto.device.RegisterDeviceRequestDTO;

/**
 * @author administrator
 *
 */
public interface DeviceService {

	public DeviceInfo registerDevice(RegisterDeviceRequestDTO deviceInfoDTO);
	public DeviceInfo deregisterDevice(String deviceId);
	public DeviceInfo reregisterDevice(String deviceId);
}
