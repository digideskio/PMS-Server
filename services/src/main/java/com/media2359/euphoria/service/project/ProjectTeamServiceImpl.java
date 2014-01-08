package com.media2359.euphoria.service.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.media2359.euphoria.dao.project.ProjectTeamDAO;
import com.media2359.euphoria.model.project.ProjectTeam;
import com.media2359.euphoria.view.dto.project.ProjectTeamDTO;
import com.media2359.euphoria.view.server.project.ProjectTeamService;


@Service("ProjectTeamService")
public class ProjectTeamServiceImpl implements ProjectTeamService {

	@Autowired
	private ProjectTeamDAO projectTeamDao;
	@Override
	public ProjectTeamDTO getProjectTeam(Integer projectKey) {
		return projectTeamDao.getProjectTeam(projectKey).prepareProjectTeamDTO();
	}

	
	@Override
	public String submitProjectTeam(ProjectTeamDTO projectTeamDto)  {
		try{
			ProjectTeam projectTeam = projectTeamDao.getProjectTeam(projectTeamDto.getProjectTeamKey());
			if(projectTeam!=null){
				projectTeamDao.updateProjectTeam(projectTeamDto.prepareProjectTeam());
				
			}else{
				projectTeamDao.addProjectTeam(projectTeamDto.prepareProjectTeam());
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
