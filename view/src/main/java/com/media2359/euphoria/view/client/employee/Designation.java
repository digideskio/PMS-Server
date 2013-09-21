/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.view.client.employee;

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

enum Designation{
	  DESIGNATION1("Project Manager"), DESIGNATION2("Software Engineer"), DESIGNATION3("QA"), DESIGNATION4("Admin"), DESIGNATION5("Designer"), DESIGNATION6("UX"),DESIGNATION7("Sales");
		static Designation parseString(String object) {
			if (Designation.DESIGNATION1.toString().equals(object)) {
				return Designation.DESIGNATION1;
			} else if (Designation.DESIGNATION2.toString().equals(object)) {
				return Designation.DESIGNATION2;
			} else if (Designation.DESIGNATION3.toString().equals(object)) {
				return Designation.DESIGNATION3;
			} else if (Designation.DESIGNATION4.toString().equals(object)) {
				return Designation.DESIGNATION4;
			} else if (Designation.DESIGNATION5.toString().equals(object)) {
				return Designation.DESIGNATION5;
			} else if (Designation.DESIGNATION6.toString().equals(object)) {
				return Designation.DESIGNATION6;
			} else if (Designation.DESIGNATION7.toString().equals(object)) {
				return Designation.DESIGNATION7;
			} else {
				return Designation.DESIGNATION1;
			} 
		}
		private String text;

		Designation(String text) {
			this.text = text;
		}

		@Override
		public String toString() {
			return text;
		}
		
		protected static List<Designation> getDesignations(){
			List<Designation> designationList = new ArrayList<Designation>();
			designationList.add(DESIGNATION1);
			designationList.add(DESIGNATION2);
			designationList.add(DESIGNATION3);
			designationList.add(DESIGNATION4);
			designationList.add(DESIGNATION5);
			designationList.add(DESIGNATION6);
			return designationList;
		}
};
