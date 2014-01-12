/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.dao.manpower;

import java.util.Date;
import java.util.Set;
import java.util.List;

import com.media2359.euphoria.model.employee.Employee;
import com.media2359.euphoria.model.manpower.*;
import com.media2359.euphoria.model.project.*;

/**
 * PlatformRequestDAO
 *
 * TODO Write something about this class
 * 
 * @author ty
 * @version 1.0 2013
 **/

public interface PlatformRequestDAO {

	/*Set<WeeklyManpowerRequest> findAllRequestsForEmployee(Employee employee);
	Set<WeeklyManpowerRequest> findRequestsForEmployee(Employee employee, Date startDate, Date endDate);
	void saveManpowerRequestsForEmployee(Employee employee, Set<WeeklyManpowerRequest> weeklyManpowerRequests);*/
	
	List<PlatformRequest> findAllPlatformRequest(WeeklyManpowerRequest weeklyManpowerRequest);
	Integer getMaxKey();
	void addPlatformRequest(PlatformRequest platformRequest);
}
