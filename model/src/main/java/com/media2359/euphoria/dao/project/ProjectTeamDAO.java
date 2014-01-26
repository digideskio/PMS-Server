/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.dao.project;

import java.util.List;

import com.media2359.euphoria.model.employee.Employee;
import com.media2359.euphoria.model.project.Platform;
import com.media2359.euphoria.model.project.Project;
import com.media2359.euphoria.model.project.ProjectTeam;

public interface ProjectTeamDAO {
	List<ProjectTeam> getAllProjectTeams();
	ProjectTeam getProjectTeam(Project project);
	public Integer getMaxKey();
	void addProjectTeam(ProjectTeam projectTeam);
	void deleteProjectTeam(Integer projectTeamKey);
	void updateProjectTeam(ProjectTeam projectTeam);
	List<Employee> getProjectTeamMemberByPlatform(Project project, Platform platform);
}
