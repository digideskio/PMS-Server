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

import com.media2359.euphoria.model.employee.Employee;
import com.media2359.euphoria.model.manpower.WeeklyManpowerRequest;

/**
 * WeeklyManpowerRequestDAO
 *
 * TODO Write something about this class
 * 
 * @author alfreds
 * @version 1.0 2013
 **/

public interface WeeklyManpowerRequestDAO {
	/**
	 * 
	 * TODO Write something about this method
	 *
	 * @returns Set<WeeklyManpowerRequest>
	 */
	Set<WeeklyManpowerRequest> findAllRequestsForEmployee(Employee employee);
	
	/**
	 * 
	 * TODO Write something about this method
	 *
	 * @returns Set<WeeklyManpowerRequest>
	 */
	Set<WeeklyManpowerRequest> findRequestsForEmployee(Employee employee, Date startDate, Date endDate);
	
	/**
	 * 
	 * TODO Write something about this method
	 *
	 * @returns void
	 */
	void saveManpowerRequestsForEmployee(Employee employee, Set<WeeklyManpowerRequest> weeklyManpowerRequests);
}
