/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.view.dto.util;

import java.io.Serializable;
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


public enum AllocationStatus implements Serializable {


    	HOLIDAY("Holiday"," You can't select on holiday!", "Holiday"), 
    	LEAVE("Leave"," You can't select on leave!","Leave"), 
    	FREE("Free"," Not Selected, You May Select.","Not Selected"), 
    	SELECTED("Selected"," Selected, You May Unselect.", "Selected"), 
    	EXCEEDED("Exceeded"," Warning! Allocation exceeded.","Exceed Allocation"), 
    	SELECTED_EXCEEDED("Selected_Exceeded","Warning! Exceeded allocation selected.","Exceed Allocation Selected"),
    	ALLOCATED("Allocated","Allocated","Allocated");
		
		private String text;
		private String enabledTooltip;
		private String disabledTooltip;
	    
		AllocationStatus(String text, String enabledTooltip, String disabledTooltip) {
			this.text = text;
			this.enabledTooltip = enabledTooltip;
			this.disabledTooltip = disabledTooltip;
		}

		@Override
		public String toString() {
			return text;
		}
		
		public String getEnabledTooltip(){
			return enabledTooltip;
		}
		
		public String getDisabledTooltip(){
			return disabledTooltip;
		}

	}


