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

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.media2359.euphoria.model.employee.Employee;
import com.media2359.euphoria.model.project.Platform;
import com.media2359.euphoria.view.dto.employee.EmployeeDTO;
import com.media2359.euphoria.view.dto.project.PlatformDTO;
import com.media2359.euphoria.view.message.employee.EmployeeListRequest;
import com.media2359.euphoria.view.message.employee.EmployeeListResponse;


@RemoteServiceRelativePath("service/EmployeeService")
public interface EmployeeService extends RemoteService {
	public EmployeeListResponse getAllEmployees(EmployeeListRequest request);
	// Adds the employee to the database
	public String addEmployee(EmployeeDTO employee);
	
	// Modifies the employee details to the database 
	public String modifyEmployee(EmployeeDTO employee);
	//Deletes the employee details from the database 
	
	public String deleteEmployee(EmployeeDTO employee);
	
	// Gets the emplyee details from the database 
	public EmployeeDTO getEmployeeDetails(EmployeeDTO employee);
	
	// Gets the max key for the employee
	public Integer getMaxKey();
	
	// Gets all the platforms for the employee
	public List<PlatformDTO> findAllPlatforms();
	
	public List<EmployeeDTO> getEmployeesByPlatform(PlatformDTO platformDTO);
	
	public List<EmployeeDTO> getEmployeesByRole(String role);
}
