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
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.media2359.euphoria.model.manpower.WeeklyManpowerAllocation;
import com.media2359.euphoria.model.manpower.WeeklyManpowerRequest;
import com.media2359.euphoria.model.milestone.ProjectMilestone;
import com.media2359.euphoria.view.dto.milestone.ProjectMilestoneDTO;
import com.media2359.euphoria.view.dto.project.ProjectDTO;

@Entity 
@Table(name = "project")  
public class Project implements java.io.Serializable{
	private Integer id;
	private String name;
	private String description;
	private String projectManager;
	private Double manDaysLeft;
	private Integer milestoneCount;
	private Integer completedMilestoneCount;
	
	private String company;
	private String billingAddr;
	private String contactPerson;
	private Date startDate;
	private Date endDate;
	private String status;
	
	private ProjectPlan projectPlan;
	private Set<WeeklyManpowerRequest> weeklyManpowerRequests;
	private Set<WeeklyManpowerAllocation> weeklyManpowerAllocations;
	private Set<ProjectTask> projectTasks;
	private ProjectTeam projectTeam;
	private Set<PlatformProjection> platformProjections;
	private Set<ProjectDocument> projectDocuments;
	
	private Set<ProjectMilestone> projectMilestone;

	public Project() {
		// TODO Auto-generated constructor stub
	}
	
	public Project(ProjectDTO dto) {
		this.id = dto.getId();
		this.name = dto.getName();
		this.description = dto.getDescription();
		this.projectManager = dto.getProjectManager();
		this.manDaysLeft=dto.getManDaysLeft();
		//this.milestoneCount=dto.getMilestoneCount();
		this.completedMilestoneCount=dto.getMilestoneCount();
		this.setCompany(dto.getCompany());
		this.setBillingAddr(dto.getBillingAddr());
		this.setContactPerson(dto.getContactPerson());
		this.setStartDate(dto.getStartDate());
		this.setEndDate(dto.getEndDate());
		this.setStatus(dto.getStatus());
		Set<ProjectMilestone> projectMilestoneSet = new HashSet<ProjectMilestone>();
		
		if(dto.getProjectMilestone()!=null){
			for(ProjectMilestoneDTO projectMilestoneDTO : dto.getProjectMilestone()){
				if(isMilestoneValid(projectMilestoneDTO)){
					ProjectMilestone projectMilestone =new ProjectMilestone(projectMilestoneDTO);
					projectMilestone.setProject(this);
					projectMilestone.setCreatedById("SYSTEM");
					projectMilestone.setCreateTstamp(new Date());
					projectMilestoneSet.add(projectMilestone);
				}
				
			}
		}
		
		this.milestoneCount=projectMilestoneSet.size();	
		this.projectMilestone =projectMilestoneSet;
	}

	/**
	 * @return the description
	 */
	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the name
	 */
	@Column(name = "name")
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Id
	@GeneratedValue(generator = "ProjectGenerator")     
	@GenericGenerator(name = "ProjectGenerator", strategy = "increment") 
	@Column(name = "project_key")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "project_manager")
	public String getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
	}
	
	@Column(name = "mandays_left")
	public Double getManDaysLeft() {
		return manDaysLeft;
	}

	public void setManDaysLeft(Double manDaysLeft) {
		this.manDaysLeft = manDaysLeft;
	}
	
	@Column(name = "milestone_cnt")
	public Integer getMilestoneCount() {
		return milestoneCount;
	}

	public void setMilestoneCount(Integer milestoneCount) {
		this.milestoneCount = milestoneCount;
	}
	
	@Column(name = "completed_milestone_cnt")
	public Integer getCompletedMilestoneCount() {
		return completedMilestoneCount;
	}

	public void setCompletedMilestoneCount(Integer completedMilestoneCount) {
		this.completedMilestoneCount = completedMilestoneCount;
	}
	
	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="project")
	public Set<ProjectMilestone> getProjectMilestone() {
		return projectMilestone;
	}

	public void setProjectMilestone(Set<ProjectMilestone> projectMilestone) {
		this.projectMilestone = projectMilestone;
	}
	
	
	
	@Column(name = "company")
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column(name = "billing_addr")
	public String getBillingAddr() {
		return billingAddr;
	}

	public void setBillingAddr(String billingAddr) {
		this.billingAddr = billingAddr;
	}
	
	@Column(name = "contact_person")
	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	@Column(name = "start_date")
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Column(name = "end_date")
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Column(name = "status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ProjectDTO createProjectDTO() {
		ProjectDTO projectDTO = new ProjectDTO();
		projectDTO.setId(getId());
		projectDTO.setName(getName());
		projectDTO.setDescription(getDescription());
		projectDTO.setProjectManager(getProjectManager());
		projectDTO.setManDaysLeft(getManDaysLeft());
		projectDTO.setMilestoneCount(getMilestoneCount());
		projectDTO.setCompletedMilestoneCount(getCompletedMilestoneCount());
		projectDTO.setCompany(this.getCompany());
		projectDTO.setBillingAddr(this.getBillingAddr());
		projectDTO.setContactPerson(this.getContactPerson());
		projectDTO.setStartDate(this.getStartDate());
		projectDTO.setEndDate(this.getEndDate());
		projectDTO.setStatus(this.getStatus());
		
		Set<ProjectMilestoneDTO> projectMilestoneDTOSet = new HashSet<ProjectMilestoneDTO>();
		
		if(getProjectMilestone()!=null){
			for(ProjectMilestone projectMileStone: this.projectMilestone ){
				projectMilestoneDTOSet.add(projectMileStone.createProjectMilestoneDTO());
			}
		}
		
		projectDTO.setProjectMilestone(projectMilestoneDTOSet);
		
		return projectDTO;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", description="
				+ description + ", projectManager=" + projectManager
				+ ", manDaysLeft=" + manDaysLeft + ", milestoneCount="
				+ milestoneCount + ", completedMilestoneCount="
				+ completedMilestoneCount + ", company=" + company
				+ ", billingAddr=" + billingAddr + ", contactPerson="
				+ contactPerson + ", startDate=" + startDate + ", endDate="
				+ endDate + ", status=" + status + ", projectPlan="
				+ projectPlan + ", weeklyManpowerRequests="
				+ weeklyManpowerRequests + ", weeklyManpowerAllocations="
				+ weeklyManpowerAllocations + ", projectTasks=" + projectTasks
				+ ", projectTeam=" + projectTeam + ", platformProjections="
				+ platformProjections + ", projectDocuments="
				+ projectDocuments + ", projectMilestone=" + projectMilestone
				+ "]";
	}
	
	private Boolean isMilestoneValid(ProjectMilestoneDTO projectMilestoneDTO){
		Boolean isMilestoneValid= true;
		
		if((projectMilestoneDTO.getMilestoneDate()==null) &&
				(projectMilestoneDTO.getMilestoneDesc()==null || 
				"".equals(projectMilestoneDTO.getMilestoneDesc()))){
			isMilestoneValid= false;
		}
		
		System.out.println("isMilestoneValid is "+isMilestoneValid);
		return isMilestoneValid;
	}


}
