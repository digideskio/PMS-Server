/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.view.client.manpower;

// just to show the converter feature
enum Resource {
	DEVELOPER1("Shiv"), DEVELOPER2("Lung Sen"), DEVELOPER3("Tian Yang"), DEVELOPER4(
			"Praveen"), DEVELOPER5("May");
	static Resource parseString(String object) {
		if (Resource.DEVELOPER1.toString().equals(object)) {
			return Resource.DEVELOPER1;
		} else if (Resource.DEVELOPER2.toString().equals(object)) {
			return Resource.DEVELOPER2;
		} else if (Resource.DEVELOPER3.toString().equals(object)) {
			return Resource.DEVELOPER3;
		} else if (Resource.DEVELOPER4.toString().equals(object)) {
			return Resource.DEVELOPER4;
		} else {
			return Resource.DEVELOPER5;
		}
	}

	private String text;

	Resource(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return text;
	}
}
