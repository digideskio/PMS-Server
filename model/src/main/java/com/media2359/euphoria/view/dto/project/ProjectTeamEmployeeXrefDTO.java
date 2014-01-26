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

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.media2359.euphoria.model.project.Platform;
import com.media2359.euphoria.model.project.ProjectTeamEmployeeXrefId;
import com.media2359.euphoria.model.user.Role;
import com.media2359.euphoria.view.dto.employee.EmployeeDTO;

public class ProjectTeamEmployeeXrefDTO implements Serializable {
	private ProjectTeamEmployeeXrefIdDTO pk = new ProjectTeamEmployeeXrefIdDTO();
	private String projectMgrFlg;
	private PlatformDTO platformDto;
	private String status;
	private String projectRole;
	private String mandayRate; 

	public ProjectTeamEmployeeXrefDTO() {

	}

	public ProjectTeamEmployeeXrefIdDTO getPk() {
		return pk;
	}

	public void setPk(ProjectTeamEmployeeXrefIdDTO pk) {
		this.pk = pk;
	}

	public String getProjectMgrFlg() {
		return projectMgrFlg;
	}

	public void setProjectMgrFlg(String projectMgrFlg) {
		this.projectMgrFlg = projectMgrFlg;
	}

	public PlatformDTO getPlatformDto() {
		return platformDto;
	}

	public void setPlatformDto(PlatformDTO platformDto) {
		this.platformDto = platformDto;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

	public String getProjectRole() {
		return projectRole;
	}

	public void setProjectRole(String projectRole) {
		this.projectRole = projectRole;
	}

	public String getMandayRate() {
		return mandayRate;
	}

	public void setMandayRate(String mandayRate) {
		this.mandayRate = mandayRate;
	}

	@Override
	public String toString() {
		return "ProjectTeamEmployeeXrefDTO [pk=" + pk + ", projectMgrFlg="
				+ projectMgrFlg + ", platformDto=" + platformDto + ", status="
				+ status + ", projectRole=" + projectRole + ", mandayRate="
				+ mandayRate + "]";
	}
}
