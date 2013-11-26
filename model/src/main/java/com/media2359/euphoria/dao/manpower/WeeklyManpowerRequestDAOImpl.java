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
 * WeeklyManpowerRequestDAOImpl
 *
 * TODO Write something about this class
 * 
 * @author alfreds
 * @version 1.0 2013
 **/

public class WeeklyManpowerRequestDAOImpl implements WeeklyManpowerRequestDAO {

	/**
	 * 
	 */
	public WeeklyManpowerRequestDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.media2359.euphoria.dao.manpower.WeeklyManpowerRequestDAO#findAllRequestsForEmployee(com.media2359.euphoria.model.employee.Employee)
	 */
	@Override
	public Set<WeeklyManpowerRequest> findAllRequestsForEmployee(
			Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.media2359.euphoria.dao.manpower.WeeklyManpowerRequestDAO#findRequestsForEmployee(com.media2359.euphoria.model.employee.Employee, java.util.Date, java.util.Date)
	 */
	@Override
	public Set<WeeklyManpowerRequest> findRequestsForEmployee(
			Employee employee, Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.media2359.euphoria.dao.manpower.WeeklyManpowerRequestDAO#saveManpowerRequestsForEmployee(com.media2359.euphoria.model.employee.Employee, java.util.Set)
	 */
	@Override
	public void saveManpowerRequestsForEmployee(Employee employee,
			Set<WeeklyManpowerRequest> weeklyManpowerRequests) {
		// TODO Auto-generated method stub
		
	}

}
