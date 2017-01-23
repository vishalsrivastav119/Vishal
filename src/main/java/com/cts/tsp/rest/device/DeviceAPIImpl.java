/**
 * 
 */
package com.cts.tsp.rest.device;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cts.tsp.domain.DeviceInfo;
import com.cts.tsp.dto.device.RegisterDeviceRequestDTO;
import com.cts.tsp.service.device.DeviceService;

/**
 * @author administrator
 *
 */
@Component
@Path("/v1/devices")
public class DeviceAPIImpl implements DeviceAPI {

	@Autowired
	private DeviceService deviceService;
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public DeviceInfo registerDevice(RegisterDeviceRequestDTO deviceInfoDTO) {
		return deviceService.registerDevice(deviceInfoDTO);
	}

	@PUT
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public DeviceInfo updateRegistration(@PathParam("id") String deviceId, @QueryParam("flag") Integer updateType) {
		DeviceInfo deviceInfo = null;
		if(updateType == 0){
			deviceInfo = deviceService.deregisterDevice(deviceId);
		}else{
			deviceInfo = deviceService.reregisterDevice(deviceId);
		}
		return deviceInfo;
	}
}

