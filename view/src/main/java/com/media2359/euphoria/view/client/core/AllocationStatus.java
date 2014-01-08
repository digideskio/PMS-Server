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

import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;


/**
 * Platforms
 *
 * TODO Write something about this class
 * 
 * @author PraveenJose
 * @version 1.0 2013
 **/


public enum AllocationStatus {
	

	
		HOLIDAY("Holiday"), LEAVE("Leave"), FREE("Free"), SELECTED(
				"Selected"), EXCEEDED("Exceeded"), SELECTED_EXCEEDED("Selected_Exceeded");
		
		private String text;
		
		
		AllocationStatus(String text) {
			this.text = text;
		}

		@Override
		public String toString() {
			return text;
		}
		
	

	}


