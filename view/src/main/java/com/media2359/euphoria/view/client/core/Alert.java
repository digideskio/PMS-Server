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

import com.sencha.gxt.core.client.util.Format;
import com.sencha.gxt.widget.core.client.Dialog;
import com.sencha.gxt.widget.core.client.box.AlertMessageBox;
import com.sencha.gxt.widget.core.client.event.HideEvent;
import com.sencha.gxt.widget.core.client.event.HideEvent.HideHandler;
import com.sencha.gxt.widget.core.client.info.Info;

/**
 * Alert
 *
 * TODO Write something about this class
 * 
 * @author Praveen
 * @version 1.0 2013
 **/

public class Alert {

	final HideHandler hideHandler = new HideHandler() {
	      @Override
	      public void onHide(HideEvent event) {
	        Dialog btn = (Dialog) event.getSource();
//	        String msg = Format.substitute("The '{0}' button was pressed", btn.getHideButton().getText());
//	        Info.display("MessageBox", msg);
	      }
	    };
	    
	    public Alert(String title, String content){
	    	AlertMessageBox d = new AlertMessageBox(title, content);
	        d.addHideHandler(hideHandler);	
	        d.show();
	    }    
	    
	    
}
