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
import java.util.Set;

import com.media2359.euphoria.view.dto.milestone.ProjectMilestoneDTO;

public class ProjectDTO implements Serializable {
        private Integer id;
        private String name;
        private String description;
        private String projectManager;
        private Integer manDaysLeft;
        private Integer milestoneCount;
        private Integer completedMilestoneCount;
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


        public Integer getManDaysLeft() {
                return manDaysLeft;
        }

        public void setManDaysLeft(Integer manDaysLeft) {
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

		@Override
		public String toString() {
			return "ProjectDTO [id=" + id + ", name=" + name + ", description="
					+ description + ", projectManager=" + projectManager
					+ ", manDaysLeft=" + manDaysLeft + ", milestoneCount="
					+ milestoneCount + ", completedMilestoneCount="
					+ completedMilestoneCount + ", projectMilestone="
					+ projectMilestone + "]";
		}

        
        
}