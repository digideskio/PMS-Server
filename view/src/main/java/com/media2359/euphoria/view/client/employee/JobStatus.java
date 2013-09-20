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
 * JobStatus
 *
 * TODO Write something about this class
 * 
 * @author PraveenJose
 * @version 1.0 2013
 **/

enum JobStatus{
	  STATUS1("Active"), STATUS2("Terminated");
		static JobStatus parseString(String object) {
			if (JobStatus.STATUS1.toString().equals(object)) {
				return JobStatus.STATUS1;
			} else if (JobStatus.STATUS2.toString().equals(object)) {
				return JobStatus.STATUS2;
			} else{
				return JobStatus.STATUS1;
			} 
		}
		private String text;

		JobStatus(String text) {
			this.text = text;
		}

		@Override
		public String toString() {
			return text;
		}
};

