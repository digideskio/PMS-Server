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
 * JobStatus
 *
 * TODO Write something about this class
 * 
 * @author PraveenJose
 * @version 1.0 2013
 **/

public enum ProjectStatus{
	  ACTIVE("Active"), COMPLETE("Commplete");
	  
	  private static List<ProjectStatus> statusList;
	  private String text;
	  
	  public static ProjectStatus parseString(String object) {
			if (ProjectStatus.ACTIVE.toString().equals(object)) {
				return ProjectStatus.ACTIVE;
			} else if (ProjectStatus.COMPLETE.toString().equals(object)) {
				return ProjectStatus.COMPLETE;
			} else{
				return ProjectStatus.ACTIVE;
			} 
		}
		
	  ProjectStatus(String text) {
			this.text = text;
		}

		@Override
		public String toString() {
			return text;
		}
		
		public static List<ProjectStatus> getAllStatus(){
			if(statusList  != null)
				return statusList;
			
			statusList = new ArrayList<ProjectStatus>();
			statusList.add(ACTIVE);
			statusList.add(COMPLETE);
			return statusList;
		}
};

