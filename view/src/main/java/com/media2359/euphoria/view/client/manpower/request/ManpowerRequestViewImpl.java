/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.view.client.manpower.request;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.sencha.gxt.widget.core.client.Composite;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;

/**
 * ManpowerRequestView
 *
 * TODO Write something about this class
 * 
 * @author alfreds
 * @version 1.0 2013
 **/

public class ManpowerRequestViewImpl extends Composite implements ManpowerRequestView {
	@UiTemplate("ManpowerRequestView.ui.xml")
	interface ManpowerRequestViewUiBinder extends UiBinder<VerticalLayoutContainer, ManpowerRequestViewImpl> {}
	private static ManpowerRequestViewUiBinder uiBinder = GWT.create(ManpowerRequestViewUiBinder.class);
	
	/**
	 * 
	 */
	public ManpowerRequestViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	/* (non-Javadoc)
	 * @see com.media2359.euphoria.view.client.manpower.request.ManpowerRequestView#setProjectTitle(java.lang.String)
	 */
	public void setProjectTitle(String projectName) {
		// TODO Auto-generated method stub
		
	}

}
