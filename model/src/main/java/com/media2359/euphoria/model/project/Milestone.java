/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.model.project;

import java.util.Date;
import java.util.Set;

import com.media2359.euphoria.model.employee.Employee;

/**
 * ProjectMilestone
 *
 * TODO Write something about this class
 * 
 * @author alfreds
 * @version 1.0 2013
 **/

public class Milestone {
	String name;
	int status;
	Employee createdBy;
	Date dueDate;
	Date firstReminderDate;
	Set<Employee> milestoneRemindees;
	
	/**
	 * 
	 */
	public Milestone() {
		// TODO Auto-generated constructor stub
	}

}
