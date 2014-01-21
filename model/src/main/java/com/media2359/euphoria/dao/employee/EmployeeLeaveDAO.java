/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.dao.employee;

/**
 * EmployeeLeaveDao
 *
 * TODO Write something about this class
 * 
 * @author TY
 * @version 1.0 2013
 **/


import java.util.Date;
import java.util.List;

import com.media2359.euphoria.model.employee.Employee;
import com.media2359.euphoria.model.employee.EmployeeLeave;
import com.media2359.euphoria.model.project.Platform;


public interface EmployeeLeaveDAO {
	List<EmployeeLeave> getAllLeaves();
	List<EmployeeLeave> getAllLeavesByEmployee(Employee employee, Date startDate, Date endDate);
	Integer getMaxKey();
}
