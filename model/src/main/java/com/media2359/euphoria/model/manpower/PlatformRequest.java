/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.model.manpower;

import com.media2359.euphoria.model.employee.Employee;
import com.media2359.euphoria.model.project.Platform;

/**
 * PlatformRequest
 *
 * TODO Write something about this class
 * 
 * @author alfreds
 * @version 1.0 2013
 **/

public class PlatformRequest {
	Platform requestedPlatform;
	Double effort;
	String comment;
	Employee assignedEmployee;
	
	/**
	 * 
	 */
	public PlatformRequest() {
		// TODO Auto-generated constructor stub
	}

}
