/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.view.server.employee;

/**
 * EmployeeService
 *
 * TODO Write something about this class
 * 
 * @author Praveen
 * @version 1.0 2013
 **/

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.media2359.euphoria.model.employee.Employee;
import com.media2359.euphoria.view.message.employee.EmployeeListRequest;
import com.media2359.euphoria.view.message.employee.EmployeeListResponse;


@RemoteServiceRelativePath("service/EmployeeService")
public interface EmployeeService extends RemoteService {
	public EmployeeListResponse getAllEmployees(EmployeeListRequest request);
	// Adds the employee to the database
	public String addEmployee(Employee employee);
	
	// Modifies the employee details to the database 
	public String modifyEmployee(Employee employee);
	//Deletes the employee details from the database 
	
	public String deleteEmployee(Employee employee);
	
	// Gets the emplyee details from the database 
	public Employee getEmployeeDetails(Employee employee);
	
	// Gets the max key for the employee
	public Integer getMaxKey();
}
