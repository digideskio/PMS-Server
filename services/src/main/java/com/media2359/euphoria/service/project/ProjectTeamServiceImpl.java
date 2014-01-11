package com.media2359.euphoria.service.project;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.media2359.euphoria.dao.project.ProjectTeamDAO;
import com.media2359.euphoria.model.employee.Employee;
import com.media2359.euphoria.model.project.Project;
import com.media2359.euphoria.model.project.ProjectTeam;
import com.media2359.euphoria.model.project.ProjectTeamEmployeeXref;
import com.media2359.euphoria.view.dto.employee.EmployeeDTO;
import com.media2359.euphoria.view.dto.project.ProjectDTO;
import com.media2359.euphoria.view.dto.project.ProjectTeamDTO;
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
		
		ProjectTeamEmployeeXref projectTeamEmployeeXref=null;
		
		Project project = new Project();
		project.setId(projectTeamDto.getProjectDto().getId());
		project.setManDaysLeft(projectTeamDto.getProjectDto().getManDaysLeft());
		project.setMilestoneCount(projectTeamDto.getProjectDto().getCompletedMilestoneCount());
		project.setName(projectTeamDto.getProjectDto().getName());
		project.setProjectManager(projectTeamDto.getProjectDto().getProjectManager());
		project.setDescription(projectTeamDto.getProjectDto().getDescription());
		project.setCompletedMilestoneCount(projectTeamDto.getProjectDto().getCompletedMilestoneCount());
		projectTeam.setProject(project);
		
		
		for(EmployeeDTO employeeDto : projectTeamDto.getProjectManagers()){
			/*Employee employee = new Employee();
			employee.setEmployeeKey(Integer.valueOf(employeeDto.getEmployeeKey()));
			employee.setName(employeeDto.getName());
			employee.setMobile(employeeDto.getMobile());
			employee.setPersonalEmail(employeeDto.getPersonalEmail());
			employee.setCompanyEmail(employeeDto.getCompanyEmail());
			employee.setDesignation(employeeDto.getDesignation());
			employee.setPlatForms(employeeDto.getPlatForms());
			employee.setAssignedOffice(employeeDto.getAssignedOffice());
			employee.setEmploymentType(employeeDto.getEmploymentType());
			employee.setStartDate(employeeDto.getStartDate());
			employee.setEndDate(employeeDto.getEndDate());
			employee.setMandayRate(employeeDto.getMandayRate());*/
			
			Employee employee = new Employee(employeeDto);
			 
			projectTeamEmployeeXref = new ProjectTeamEmployeeXref();
			projectTeamEmployeeXref.setEmployee(employee);
			projectTeamEmployeeXref.setProjectTeam(projectTeam);
			projectTeamEmployeeXref.setProjectMgrFlg("Y");
			
			projectTeam.getProjectManagers().add(projectTeamEmployeeXref);
		}
		
		projectTeam.setProjectTeamKey(projectTeamDto.getProjectTeamKey());
		projectTeam.setProjectTeamName(projectTeamDto.getProjectTeamName());
		
		
		for(EmployeeDTO employeeDto: projectTeamDto.getTeamMembers()){
			/*Employee employee = new Employee();
			employee.setEmployeeKey(Integer.valueOf(employeeDto.getEmployeeKey()));
			employee.setName(employeeDto.getName());
			employee.setMobile(employeeDto.getMobile());
			employee.setPersonalEmail(employeeDto.getPersonalEmail());
			employee.setCompanyEmail(employeeDto.getCompanyEmail());
			employee.setDesignation(employeeDto.getDesignation());
			employee.setPlatForms(employeeDto.getPlatForms());
			employee.setAssignedOffice(employeeDto.getAssignedOffice());
			employee.setEmploymentType(employeeDto.getEmploymentType());
			employee.setStartDate(employeeDto.getStartDate());
			employee.setEndDate(employeeDto.getEndDate());
			employee.setMandayRate(employeeDto.getMandayRate());*/
			
			Employee employee = new Employee(employeeDto);
			
			projectTeamEmployeeXref = new ProjectTeamEmployeeXref();
			projectTeamEmployeeXref.setEmployee(employee);
			projectTeamEmployeeXref.setProjectTeam(projectTeam);
			projectTeamEmployeeXref.setProjectMgrFlg("N");
			
			projectTeam.getTeamMembers().add(projectTeamEmployeeXref);
			
		}
		projectTeam.setCreatedBy(projectTeamDto.getCreatedBy());
		projectTeam.setCreatedTstmp(new Date());
		
	}
	
	

	

}
