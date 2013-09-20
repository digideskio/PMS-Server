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

/**
 * AssignedOffice
 *
 * TODO Write something about this class
 * 
 * @author PraveenJose
 * @version 1.0 2013
 **/

enum AssignedOffice{
	  OFFICE1("Singapore"), OFFICE2("Vietnam");
		static AssignedOffice parseString(String object) {
			if (AssignedOffice.OFFICE1.toString().equals(object)) {
				return AssignedOffice.OFFICE1;
			} else if (AssignedOffice.OFFICE2.toString().equals(object)) {
				return AssignedOffice.OFFICE2;
			} else{
				return AssignedOffice.OFFICE1;
			} 
		}
		private String text;

		AssignedOffice(String text) {
			this.text = text;
		}

		@Override
		public String toString() {
			return text;
		}
};
