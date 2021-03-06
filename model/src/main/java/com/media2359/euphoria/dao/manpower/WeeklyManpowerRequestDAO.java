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
import com.media2359.euphoria.model.manpower.WeeklyManpowerRequest;
import com.media2359.euphoria.model.project.*;

/**
 * WeeklyManpowerRequestDAO
 *
 * TODO Write something about this class
 * 
 * @author ty
 * @version 1.0 2013
 **/

public interface WeeklyManpowerRequestDAO {

	/*Set<WeeklyManpowerRequest> findAllRequestsForEmployee(Employee employee);
	Set<WeeklyManpowerRequest> findRequestsForEmployee(Employee employee, Date startDate, Date endDate);
	void saveManpowerRequestsForEmployee(Employee employee, Set<WeeklyManpowerRequest> weeklyManpowerRequests);*/
	
	List<WeeklyManpowerRequest> findAllWklyMpowerRqstByProjectWeek(Date startDate, Date endDate, Project project);
	WeeklyManpowerRequest getManpowerRequest(Integer wklyManpowerRqstKey);
	public Integer getMaxKey();
	void addWeeklyManpowerRequest(WeeklyManpowerRequest wklyManpowerRqst);
	void deleteWeeklyManpowerRequest(Integer wklyManpowerRqstKey);
	void updateWeeklyManpowerRequest(WeeklyManpowerRequest wklyManpowerRqst);
	void approveWeeklyManpowerRequest(WeeklyManpowerRequest wklyManpowerRqst);
	void rejectWeeklyManpowerRequest(WeeklyManpowerRequest wklyManpowerRqst);
	void deleteWeeklyManpowerRequest(Project project, Date startDate, Date endDate);
}
