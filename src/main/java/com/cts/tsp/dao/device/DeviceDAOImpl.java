/**
 * 
 */
package com.cts.tsp.dao.device;

import org.springframework.stereotype.Repository;

import com.cts.tsp.dao.GenericDAOImpl;
import com.cts.tsp.domain.DeviceInfo;

/**
 * @author administrator
 *
 */
@Repository
public class DeviceDAOImpl extends GenericDAOImpl<DeviceInfo, String> implements DeviceDAO {

}
