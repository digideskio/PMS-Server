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
 * EmployeeType
 *
 * TODO Write something about this class
 * 
 * @author PraveenJose
 * @version 1.0 2013
 **/


  



enum EmploymentType{
	  EMPL1("Full Time"), EMPL2("Part Time"), EMPL3("Internship"), EMPL4("Freelance");
		static EmploymentType parseString(String object) {
			if (EmploymentType.EMPL1.toString().equals(object)) {
				return EmploymentType.EMPL1;
			} else if (EmploymentType.EMPL2.toString().equals(object)) {
				return EmploymentType.EMPL2;
			} else if (EmploymentType.EMPL3.toString().equals(object)) {
				return EmploymentType.EMPL3;
			} else if (EmploymentType.EMPL4.toString().equals(object)) {
				return EmploymentType.EMPL4;
			}else{
				return EmploymentType.EMPL1;
			} 
		}
		private String text;

		EmploymentType(String text) {
			this.text = text;
		}

		@Override
		public String toString() {
			return text;
		}
		
		
		protected static List<EmploymentType> getEmploymentTypes(){
			List<EmploymentType> emplList = new ArrayList<EmploymentType>();
			emplList.add(EMPL1);
			emplList.add(EMPL2);
			emplList.add(EMPL3);
			emplList.add(EMPL4);
			return emplList;
		}
};