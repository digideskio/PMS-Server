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
 * Platform
 *
 * TODO Write something about this class
 * 
 * @author alfreds
 * @version 1.0 2013
 *
 */
enum Platform {
	ANDROID("Android"), IOS("iOS"), RUBY("Ruby"), GRAILS(
			"Grails"), SERVER("Server"), UI("UI");
	static Platform parseString(String object) {
		if (Platform.ANDROID.toString().equals(object)) {
			return Platform.ANDROID;
		} else if (Platform.IOS.toString().equals(object)) {
			return Platform.IOS;
		} else if (Platform.RUBY.toString().equals(object)) {
			return Platform.RUBY;
		} else if (Platform.GRAILS.toString().equals(object)) {
			return Platform.GRAILS;
		} else if (Platform.UI.toString().equals(object)) {
			return Platform.UI;
		} else {
			return Platform.SERVER;
		}
	}

	private String text;

	Platform(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return text;
	}
}
