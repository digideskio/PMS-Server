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

/**
 * 
 * DayOfWeek
 *
 * TODO Write something about this class
 * 
 * @author alfreds
 * @version 1.0 2013
 *
 */
enum DayOfWeek {
	SUNDAY("Sunday"), MONDAY("Monday"), TUESDAY("Tuesday"), WEDNESDAY(
			"Wednesday"), THURSDAY("Thursday"), FRIDAY("Friday"), SATURDAY("Saturday");
	static DayOfWeek parseString(String object) {
		if (DayOfWeek.SUNDAY.toString().equals(object)) {
			return DayOfWeek.SUNDAY;
		} else if (DayOfWeek.MONDAY.toString().equals(object)) {
			return DayOfWeek.MONDAY;
		} else if (DayOfWeek.TUESDAY.toString().equals(object)) {
			return DayOfWeek.TUESDAY;
		} else if (DayOfWeek.WEDNESDAY.toString().equals(object)) {
			return DayOfWeek.WEDNESDAY;
		} else if (DayOfWeek.THURSDAY.toString().equals(object)) {
			return DayOfWeek.THURSDAY;
		} else if (DayOfWeek.FRIDAY.toString().equals(object)) {
			return DayOfWeek.FRIDAY;
		} else if (DayOfWeek.SATURDAY.toString().equals(object)) {
			return DayOfWeek.SATURDAY;
		} else {
			return DayOfWeek.MONDAY;
		}
	}

	private String text;

	DayOfWeek(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return text;
	}
}
