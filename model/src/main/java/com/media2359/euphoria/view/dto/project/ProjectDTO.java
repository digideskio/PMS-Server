/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.view.dto.project;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import com.media2359.euphoria.view.dto.milestone.ProjectMilestoneDTO;

public class ProjectDTO implements Serializable {
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
    	
    	// Number of Mandays left or selection
    	private Double noOfMandaysLeftForSelection;
    	
        private Set<ProjectMilestoneDTO> projectMilestone;

        public ProjectDTO() {

        }

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }


        public String getProjectManager() {
                return projectManager;
        }

        public void setProjectManager(String projectManager) {
                this.projectManager = projectManager;
        }

        public Double getManDaysLeft() {
			return manDaysLeft;
		}

		public void setManDaysLeft(Double manDaysLeft) {
			this.manDaysLeft = manDaysLeft;
		}

		public Integer getMilestoneCount() {
                return milestoneCount;
        }

        public void setMilestoneCount(Integer milestoneCount) {
                this.milestoneCount = milestoneCount;
        }

        public Integer getCompletedMilestoneCount() {
                return completedMilestoneCount;
        }

        public void setCompletedMilestoneCount(Integer completedMilestoneCount) {
                this.completedMilestoneCount = completedMilestoneCount;
        }

		public Set<ProjectMilestoneDTO> getProjectMilestone() {
			return projectMilestone;
		}

		public void setProjectMilestone(Set<ProjectMilestoneDTO> projectMilestone) {
			this.projectMilestone = projectMilestone;
		}

		
		
		public String getCompany() {
			return company;
		}

		public void setCompany(String company) {
			this.company = company;
		}

		public String getBillingAddr() {
			return billingAddr;
		}

		public void setBillingAddr(String billingAddr) {
			this.billingAddr = billingAddr;
		}

		public String getContactPerson() {
			return contactPerson;
		}

		public void setContactPerson(String contactPerson) {
			this.contactPerson = contactPerson;
		}

		public Date getStartDate() {
			return startDate;
		}

		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}

		public Date getEndDate() {
			return endDate;
		}

		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}
		
		public Double getNoOfMandaysLeftForSelection() {
			return noOfMandaysLeftForSelection;
		}

		public void setNoOfMandaysLeftForSelection(Double noOfMandaysLeftForSelection) {
			this.noOfMandaysLeftForSelection = noOfMandaysLeftForSelection;
		}

		@Override
		public String toString() {
			return "ProjectDTO [id=" + id + ", name=" + name + ", description="
					+ description + ", projectManager=" + projectManager
					+ ", manDaysLeft=" + manDaysLeft + ", milestoneCount="
					+ milestoneCount + ", completedMilestoneCount="
					+ completedMilestoneCount + ", company=" + company
					+ ", billingAddr=" + billingAddr + ", contactPerson="
					+ contactPerson + ", startDate=" + startDate + ", endDate="
					+ endDate + ", status=" + status + ", projectMilestone="
					+ projectMilestone + "noOfMandaysLeftForSelection"+noOfMandaysLeftForSelection+"]";
		}

		
        
}