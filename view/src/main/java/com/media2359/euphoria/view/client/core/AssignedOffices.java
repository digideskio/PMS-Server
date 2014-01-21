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
 * AssignedOffice
 *
 * TODO Write something about this class
 * 
 * @author PraveenJose
 * @version 1.0 2013
 **/

public enum AssignedOffices{
	  OFFICE1("Singapore"), OFFICE2("Vietnam");
	  
	    private static List<AssignedOffices> officeList;
		private String text;
		
		public static AssignedOffices parseString(String object) {
			if (AssignedOffices.OFFICE1.toString().equals(object)) {
				return AssignedOffices.OFFICE1;
			} else if (AssignedOffices.OFFICE2.toString().equals(object)) {
				return AssignedOffices.OFFICE2;
			} else{
				return AssignedOffices.OFFICE1;
			} 
		}


		AssignedOffices(String text) {
			this.text = text;
		}

		@Override
		public String toString() {
			return text;
		}
		
		public static List<AssignedOffices> getOffices(){
			if(officeList != null)
				return officeList;
			officeList = new ArrayList<AssignedOffices>();
			officeList.add(OFFICE1);
			officeList.add(OFFICE2);
			return officeList;
		}
};
