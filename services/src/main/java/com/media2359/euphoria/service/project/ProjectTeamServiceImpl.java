package com.media2359.euphoria.service.project;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.media2359.euphoria.dao.project.ProjectTeamDAO;
import com.media2359.euphoria.model.project.Project;
import com.media2359.euphoria.model.project.ProjectTeam;
import com.media2359.euphoria.view.dto.project.ProjectDTO;
import com.media2359.euphoria.view.dto.project.ProjectTeamDTO;
import com.media2359.euphoria.view.server.project.ProjectTeamService;


@Service("ProjectTeamService")
public class ProjectTeamServiceImpl implements ProjectTeamService {

	@Autowired
	private ProjectTeamDAO projectTeamDao;
	
	@Override
	public ProjectTeamDTO getProjectTeam(Integer projectKey) {
		Project project = new Project();
		project.setId(projectKey);
		return projectTeamDao.getProjectTeam(project).prepareProjectTeamDTO();
	}

	
	@Override
	public String submitProjectTeam(ProjectTeamDTO projectTeamDto)  {
		try{
			ProjectTeam projectTeam = projectTeamDao.getProjectTeam(projectTeamDto.getProject());
			if(projectTeam!=null){
				projectTeam.setProject(projectTeamDto.getProject());
				projectTeam.setProjectManagers(projectTeamDto.getProjectManagers());
				projectTeam.setProjectTeamKey(projectTeamDto.getProjectTeamKey());
				projectTeam.setProjectTeamName(projectTeamDto.getProjectTeamName());
				projectTeam.setTeamMembers(projectTeamDto.getTeamMembers());
				projectTeam.setCreatedBy(projectTeamDto.getCreatedBy());
				projectTeam.setCreatedTstmp(new Date());
				projectTeamDao.updateProjectTeam(projectTeam);
				
			}else{
				projectTeam = new ProjectTeam();
				projectTeam.setProject(projectTeamDto.getProject());
				projectTeam.setProjectManagers(projectTeamDto.getProjectManagers());
				projectTeam.setProjectTeamKey(projectTeamDto.getProjectTeamKey());
				projectTeam.setProjectTeamName(projectTeamDto.getProjectTeamName());
				projectTeam.setTeamMembers(projectTeamDto.getTeamMembers());
				projectTeam.setCreatedBy(projectTeamDto.getCreatedBy());
				projectTeam.setCreatedTstmp(new Date());
				projectTeamDao.addProjectTeam(projectTeam);
			}
			return "SUCCESS";
		}catch(Exception exp){
			return "FAILED";
		}
	}
	
	
/*	
	@Transactional(rollbackFor=Exception.class,propagation=Propagation.REQUIRED)
	private void updateProjectTeam(ProjectTeamDTO projectTeamDto) throws Exception{

		
		
		
		
	}
	*/

	

}
