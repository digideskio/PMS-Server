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
		this.id = Integer.valueOf(dto.getId());
		this.name = dto.getName();
		this.description = dto.getDescription();
		this.projectManager = dto.getProjectManager();
		this.manDaysLeft=dto.getManDaysLeft();
		this.milestoneCount=dto.getMilestoneCount();
		this.completedMilestoneCount=dto.getMilestoneCount();
		Set<ProjectMilestone> projectMilestoneSet = new HashSet<ProjectMilestone>();
		
		if(dto.getProjectMilestone()!=null){
			for(ProjectMilestoneDTO projectMilestoneDTO : dto.getProjectMilestone()){
				projectMilestoneSet.add(new ProjectMilestone(projectMilestoneDTO));
			}
		}
		
			
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

	public ProjectDTO createProjectDTO() {
		ProjectDTO projectDTO = new ProjectDTO();
		projectDTO.setId(getId());
		projectDTO.setName(getName());
		projectDTO.setDescription(getDescription());
		projectDTO.setProjectManager(getProjectManager());
		projectDTO.setManDaysLeft(getManDaysLeft());
		projectDTO.setMilestoneCount(getMilestoneCount());
		projectDTO.setCompletedMilestoneCount(getCompletedMilestoneCount());
		
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
				+ completedMilestoneCount + ", projectPlan=" + projectPlan
				+ ", weeklyManpowerRequests=" + weeklyManpowerRequests
				+ ", weeklyManpowerAllocations=" + weeklyManpowerAllocations
				+ ", projectTasks=" + projectTasks + ", projectTeam="
				+ projectTeam + ", platformProjections=" + platformProjections
				+ ", projectDocuments=" + projectDocuments
				+ ", projectMilestone=" + projectMilestone + "]";
	}
}
