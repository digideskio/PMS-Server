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

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.media2359.euphoria.view.message.employee.EmployeeListRequest;
import com.media2359.euphoria.view.message.employee.EmployeeListResponse;


public interface EmployeeServiceAsync {
	public void getAllEmployees(EmployeeListRequest request, AsyncCallback<EmployeeListResponse> callback);
	
}
