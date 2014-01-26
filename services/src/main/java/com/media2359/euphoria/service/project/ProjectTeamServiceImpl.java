package com.media2359.euphoria.service.project;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.media2359.euphoria.dao.project.ProjectTeamDAO;
import com.media2359.euphoria.model.employee.Employee;
import com.media2359.euphoria.model.project.Platform;
import com.media2359.euphoria.model.project.Project;
import com.media2359.euphoria.model.project.ProjectTeam;
import com.media2359.euphoria.model.project.ProjectTeamEmployeeXref;
import com.media2359.euphoria.view.dto.employee.EmployeeDTO;
import com.media2359.euphoria.view.dto.project.PlatformDTO;
import com.media2359.euphoria.view.dto.project.ProjectDTO;
import com.media2359.euphoria.view.dto.project.ProjectTeamDTO;
import com.media2359.euphoria.view.dto.project.ProjectTeamEmployeeXrefDTO;
import com.media2359.euphoria.view.server.project.ProjectTeamService;


@Service("ProjectTeamService")
public class ProjectTeamServiceImpl implements ProjectTeamService {

	@Autowired
	private ProjectTeamDAO projectTeamDao;
	
	@Override
	public ProjectTeamDTO getProjectTeam(ProjectDTO projectDTO) {
		Project project = new Project();
		project.setId(projectDTO.getId());
		return projectTeamDao.getProjectTeam(project).prepareProjectTeamDTO();
	}

	
	@Override
	public String submitProjectTeam(ProjectTeamDTO projectTeamDto)  {
		try{
			Project project = new Project();
			project.setId(projectTeamDto.getProjectDto().getId());
			ProjectTeam projectTeam = projectTeamDao.getProjectTeam(project);
			if(projectTeam!=null){
				
				prepareProjectTeam(projectTeamDto, projectTeam);
				projectTeamDao.updateProjectTeam(projectTeam);
				
			}else{
				projectTeam = new ProjectTeam();
				prepareProjectTeam(projectTeamDto, projectTeam);
				projectTeamDao.addProjectTeam(projectTeam);
			}
			return "SUCCESS";
		}catch(Exception exp){
			exp.printStackTrace();
			return "FAILED";
		}
	}
	
	
/*	
	@Transactional(rollbackFor=Exception.class,propagation=Propagation.REQUIRED)
	private void updateProjectTeam(ProjectTeamDTO projectTeamDto) throws Exception{

	}
	*/
	
	private void prepareProjectTeam(ProjectTeamDTO projectTeamDto, ProjectTeam projectTeam) {
		
		projectTeam.setProject(new Project(projectTeamDto.getProjectDto()));
		projectTeam.setProjectTeamKey(projectTeamDto.getProjectTeamKey());
		projectTeam.setProjectTeamName(projectTeamDto.getProjectTeamName());
		
		Set<ProjectTeamEmployeeXref> projectManagerSet = new HashSet<ProjectTeamEmployeeXref>(); 
	 	
		if(projectTeamDto.getProjectManagers()!=null){
			for(ProjectTeamEmployeeXrefDTO employeeXrefDTO : projectTeamDto.getProjectManagers()){
				projectManagerSet.add(new ProjectTeamEmployeeXref(employeeXrefDTO));
			}
		}
		projectTeam.setProjectManagers(projectManagerSet);
		
		Set<ProjectTeamEmployeeXref> teamMemberSet = new HashSet<ProjectTeamEmployeeXref>();
		if(projectTeamDto.getTeamMembers()!=null){
			for(ProjectTeamEmployeeXrefDTO teamMemberEmpXrefDTO : projectTeamDto.getTeamMembers()){
				projectManagerSet.add(new ProjectTeamEmployeeXref(teamMemberEmpXrefDTO));
			}
		}
		
		projectTeam.setTeamMembers(teamMemberSet);
		projectTeam.setCreatedBy("SYSTEM");
		projectTeam.setCreatedTstmp(new Date());
		
	}


	@Override
	public List<EmployeeDTO> getProjectTeamMember(ProjectDTO projectDTO,
			PlatformDTO platformDTO) {
		
		List<EmployeeDTO> employeeDtoList = null;
		List<Employee> employeeList =projectTeamDao.getProjectTeamMemberByPlatform(new Project(projectDTO), 
				new Platform(platformDTO));
		if(employeeList!=null){
			
			employeeDtoList = new ArrayList<EmployeeDTO>();
			for(Employee employee : employeeList){
				employeeDtoList.add(employee.createEmployeeDTO());
			}
			
		}
		return employeeDtoList;
	}
	
	

	

}
