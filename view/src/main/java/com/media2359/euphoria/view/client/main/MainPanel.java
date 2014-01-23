/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.view.client.main;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.Style.LayoutRegion;
import com.sencha.gxt.widget.core.client.Composite;
import com.sencha.gxt.widget.core.client.TabItemConfig;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;

public class MainPanel extends Composite {
	private static final String PROJECT_MANAGER = "PM";
	private static final String VP = "VP";

	interface MyUiBinder extends UiBinder<Widget, MainPanel> {

	}

	@UiField TextButton welcomelabel;
	@UiField BorderLayoutContainer con;
	@UiField TabPanel maintab;
	
	public String userRole = null;
	
	private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

	public MainPanel() {
		initWidget(uiBinder.createAndBindUi(this));
		//collapse the WEST region
		con.collapse(LayoutRegion.WEST);
		
		//Now set the style
		con.addStyleName("myBodyStyle");
		
		//Tab panel
		maintab.addStyleName("myTabStyle");
		
		populateUsername();
		
		userRole = getUserRole();
		
		
		if((userRole == null) || ("".equals(userRole))) {
			userRole = PROJECT_MANAGER;
		}
		
		if(!VP.equals(userRole)) {
			Widget child = maintab.getWidget(2);//Assuming second tab is Approval Tab
			TabItemConfig config = maintab.getConfig(child);
			config.setEnabled(false); //Disable the tab
			config.setClosable(true);
		}
	}
	
	private void populateUsername() {
		String username = getUsername();
		welcomelabel.setText(username);
	}
	
	public static native String getUsername()/*-{
    	return $wnd.getLoginUsername();
	}-*/; 
	
	public static native String getUserRole()/*-{
		return $wnd.getUserRole();
	}-*/;
	
	/*
	@UiHandler("logoutButton")
	public void handleLogout(ClickEvent clickEvent) {
		final ConfirmMessageBox confirm = new ConfirmMessageBox("Confirmation","Are you sure you want to logout?");
		confirm.addHideHandler(new HideHandler() {
		      public void onHide(HideEvent event) {
		          if (confirm.getHideButton() == confirm.getButtonById(PredefinedButton.YES.name())) {
		            // Upon YES, redirect to logout
		        	Window.open("/jsp/login/logout.jsp", "_top", null);
		          } else if (confirm.getHideButton() == confirm.getButtonById(PredefinedButton.NO.name())){
		            // perform NO action
		          }
		        }
		      });
		confirm.show();
	}*/
}
