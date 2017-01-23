/**
 * 
 */
package com.cts.tsp.service.device;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.tsp.dao.device.CustomerInfoDAO;
import com.cts.tsp.dao.device.DeviceDAO;
import com.cts.tsp.domain.CustomerInfo;
import com.cts.tsp.domain.DeviceInfo;
import com.cts.tsp.domain.enumerations.DeviceStatus;
import com.cts.tsp.dto.device.RegisterDeviceRequestDTO;
import com.cts.tsp.exception.ApplicationException;
import com.cts.tsp.exception.ErrorCode;

/**
 * @author administrator
 *
 */
@Service
@Transactional
public class DeviceServiceImpl implements DeviceService {
	@Autowired
	private DeviceDAO deviceDAO;
	
	@Autowired
	private CustomerInfoDAO CustomerInfoDAO;

	@Override
	public DeviceInfo registerDevice(RegisterDeviceRequestDTO deviceInfoDTO) {
		DeviceInfo deviceInfo = new DeviceInfo();
		CustomerInfo customerInfo = CustomerInfoDAO.getByActivationCode(deviceInfoDTO.getActivationCode());
		
		if(customerInfo == null){
			throw new ApplicationException(ErrorCode.ERR_30000);
		}
		
		deviceInfo .setDeviceId(UUID.randomUUID().toString());
		deviceInfo .setImei(deviceInfoDTO.getImei());
		deviceInfo .setMake(deviceInfoDTO.getMake());
		deviceInfo .setModel(deviceInfoDTO.getModel());
		deviceInfo .setMsisdn(deviceInfoDTO.getMsisdn());
		deviceInfo .setSdkVersion(deviceInfoDTO.getSdkVersion());
		deviceInfo.setCustomerInfo(customerInfo);
		deviceInfo.setStatus(DeviceStatus.Activated);
		return deviceDAO.create(deviceInfo);
	}

	@Override
	public DeviceInfo deregisterDevice(String deviceId) {
		DeviceInfo device = deviceDAO.find(deviceId);
		device.setStatus(DeviceStatus.Deactivated); 
		if(device == null){
			throw new ApplicationException(ErrorCode.ERR_30001);
		}
		return deviceDAO.update(device);
	}

	@Override
	public DeviceInfo reregisterDevice(String deviceId) {
		DeviceInfo device = deviceDAO.find(deviceId);
		device.setStatus(DeviceStatus.Activated); 
		if(device == null){
			throw new ApplicationException(ErrorCode.ERR_30001);
		}
		return deviceDAO.update(device);
	}
}
