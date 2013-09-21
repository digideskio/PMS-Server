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
 * Platforms
 *
 * TODO Write something about this class
 * 
 * @author PraveenJose
 * @version 1.0 2013
 **/


public enum Platforms {
	

	
		ANDROID("Android"), IOS("iOS"), RUBY("Ruby"), GRAILS(
				"Grails"), SERVER("Server"), UI("UI"), HTML("HTML"), JAVA("Java");
		
		
		private static List<Platforms> platformList;
		private String text;
		
		public static Platforms parseString(String object) {
			if (Platforms.ANDROID.toString().equals(object)) {
				return Platforms.ANDROID;
			} else if (Platforms.IOS.toString().equals(object)) {
				return Platforms.IOS;
			} else if (Platforms.RUBY.toString().equals(object)) {
				return Platforms.RUBY;
			} else if (Platforms.GRAILS.toString().equals(object)) {
				return Platforms.GRAILS;
			} else if (Platforms.UI.toString().equals(object)) {
				return Platforms.UI;
			} else {
				return Platforms.SERVER;
			}
		}

		
		Platforms(String text) {
			this.text = text;
		}

		@Override
		public String toString() {
			return text;
		}
		
		
		public static List<Platforms> getAllPlatforms(){
			if(platformList != null)
				return platformList;
			
			platformList = new ArrayList<Platforms>();
			platformList.add(ANDROID);
			platformList.add(IOS);
			platformList.add(RUBY);
			platformList.add(GRAILS);
			platformList.add(SERVER);
			platformList.add(UI);
			platformList.add(HTML);
			platformList.add(JAVA);
			
			return platformList;
		}
		

	}


