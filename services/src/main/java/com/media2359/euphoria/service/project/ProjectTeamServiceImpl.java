package com.media2359.euphoria.service.project;

import org.springframework.stereotype.Service;

import com.media2359.euphoria.model.employee.Employee;
import com.media2359.euphoria.model.project.Project;
import com.media2359.euphoria.model.project.ProjectTeam;
import com.media2359.euphoria.view.server.project.ProjectTeamService;


@Service("ProjectTeamService")
public class ProjectTeamServiceImpl implements ProjectTeamService {

	@Override
	public String addProjectTeam(Project project, ProjectTeam projectTeam) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String modifyProjectTeam(Project project, ProjectTeam projectTeam) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteProjectTeamMember(Project project, Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addProjectTeamMember(Project project, Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProjectTeam getAllTeamMembers(Project project) {
		// TODO Auto-generated method stub
		return null;
	}

}
