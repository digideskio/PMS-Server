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
 * EmployeeServiceAsync
 *
 * TODO Write something about this class
 * 
 * @author Praveen
 * @version 1.0 2013
 **/

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.media2359.euphoria.view.dto.employee.EmployeeDTO;
import com.media2359.euphoria.view.dto.project.PlatformDTO;
import com.media2359.euphoria.view.message.employee.EmployeeListRequest;
import com.media2359.euphoria.view.message.employee.EmployeeListResponse;


public interface EmployeeServiceAsync {
	public void getAllEmployees(EmployeeListRequest request, AsyncCallback<EmployeeListResponse> callback);
	
	public void addEmployee(EmployeeDTO employee,AsyncCallback<String> callback);
	
	// Modifies the employee details to the database 
	public void modifyEmployee(EmployeeDTO employee,AsyncCallback<String> callback);
	//Deletes the employee details from the database 
	
	public void deleteEmployee(EmployeeDTO employee,AsyncCallback<String> callback);
	
	// Gets the emplyee details from the database 
	public void getEmployeeDetails(EmployeeDTO employee,AsyncCallback<EmployeeDTO> callback);
	
	// Gets the max key for the employee
	public void getMaxKey(AsyncCallback<Integer> callback);
	
	// Gets all the list of the platform 
	public void  findAllPlatforms(AsyncCallback<List<PlatformDTO>> callback);
	
	public void getEmployeesByPlatform(PlatformDTO platformDTO,AsyncCallback<List<EmployeeDTO>> callback);
	
}
