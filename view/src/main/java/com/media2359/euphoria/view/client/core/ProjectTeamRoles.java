/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.view.client.core;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 *
 * TODO Write something about this class
 * 
 * @author PraveenJose
 * @version 1.0 2013
 **/

public enum ProjectTeamRoles{
	  PM("Project Manager"), TEAM_MEMBER("Team Member");
	  
	  private static List<ProjectTeamRoles> rolesList;
	  private static List<ProjectTeamRole> roleList;
	  private String text;
	  
	  public static ProjectTeamRoles parseString(String object) {
			if (ProjectTeamRoles.PM.toString().equals(object)) {
				return ProjectTeamRoles.PM;
			} else if (ProjectTeamRoles.TEAM_MEMBER.toString().equals(object)) {
				return ProjectTeamRoles.TEAM_MEMBER;
			} else{
				return ProjectTeamRoles.TEAM_MEMBER;
			} 
		}
		
	  ProjectTeamRoles(String text) {
			this.text = text;
		}

		@Override
		public String toString() {
			return text;
		}
		
		public static List<ProjectTeamRoles> getAllRoles(){
			if(rolesList  != null)
				return rolesList;
			
			rolesList = new ArrayList<ProjectTeamRoles>();
			rolesList.add(PM);
			rolesList.add(TEAM_MEMBER);
			return rolesList;
		}
		
		
		public static List<ProjectTeamRole> getAllRole(){
			
			if(roleList  != null)
				return roleList;
			 roleList = new ArrayList<ProjectTeamRole>();
			
			for(ProjectTeamRoles roles:getAllRoles())
			{
				ProjectTeamRole role = new ProjectTeamRole();
				role.setId(1);
				role.setProjectTeamRoles(roles);
				roleList.add(role);
			}
			return roleList;
		}
};

