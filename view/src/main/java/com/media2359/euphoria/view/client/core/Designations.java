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
 * Designation
 *
 * TODO Write something about this class
 * 
 * @author PraveenJose
 * @version 1.0 2013
 **/

public enum Designations{
	  DESIGNATION1("Project Manager"), DESIGNATION2("Software Engineer"), DESIGNATION3("QA"), DESIGNATION4("Admin"), DESIGNATION5("Designer"), DESIGNATION6("UX"),DESIGNATION7("Sales");
	  
	  	private  static List<Designations> designationList;
	  	private String text;
	  	
		public static Designations parseString(String object) {
			if (Designations.DESIGNATION1.toString().equals(object)) {
				return Designations.DESIGNATION1;
			} else if (Designations.DESIGNATION2.toString().equals(object)) {
				return Designations.DESIGNATION2;
			} else if (Designations.DESIGNATION3.toString().equals(object)) {
				return Designations.DESIGNATION3;
			} else if (Designations.DESIGNATION4.toString().equals(object)) {
				return Designations.DESIGNATION4;
			} else if (Designations.DESIGNATION5.toString().equals(object)) {
				return Designations.DESIGNATION5;
			} else if (Designations.DESIGNATION6.toString().equals(object)) {
				return Designations.DESIGNATION6;
			} else if (Designations.DESIGNATION7.toString().equals(object)) {
				return Designations.DESIGNATION7;
			} else {
				return Designations.DESIGNATION1;
			} 
		}
		
		Designations(String text) {
			this.text = text;
		}

		@Override
		public String toString() {
			return text;
		}
		
		public static List<Designations> getDesignations(){
			
			if(designationList!= null)
				return designationList;
			
			designationList = new ArrayList<Designations>();
			designationList.add(DESIGNATION1);
			designationList.add(DESIGNATION2);
			designationList.add(DESIGNATION3);
			designationList.add(DESIGNATION4);
			designationList.add(DESIGNATION5);
			designationList.add(DESIGNATION6);
			return designationList;
		}
};
