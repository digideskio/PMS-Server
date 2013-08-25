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
 * EmployeeDao
 *
 * TODO Write something about this class
 * 
 * @author Praveen
 * @version 1.0 2013
 **/


import java.util.List;

import com.media2359.euphoria.model.employee.Employee;

public interface EmployeeDao {
	List<Employee> getAllEmployees();
}
