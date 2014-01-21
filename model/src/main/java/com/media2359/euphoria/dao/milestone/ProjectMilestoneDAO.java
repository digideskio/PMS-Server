/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.dao.milestone;

/**
 * ProjectMilestoneDAO
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
import com.media2359.euphoria.model.milestone.ProjectMilestone;
import com.media2359.euphoria.model.project.Platform;
import com.media2359.euphoria.model.project.Project;


public interface ProjectMilestoneDAO {
	List<ProjectMilestone> getAllProjectMilestone();
	List<ProjectMilestone> getAllProjectMilestoneByProject(Project project);
	Integer getMaxKey();
}
