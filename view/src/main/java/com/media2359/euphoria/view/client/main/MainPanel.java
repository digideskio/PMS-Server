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
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.Style.LayoutRegion;
import com.sencha.gxt.widget.core.client.Composite;
import com.sencha.gxt.widget.core.client.Dialog.PredefinedButton;
import com.sencha.gxt.widget.core.client.box.ConfirmMessageBox;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.event.HideEvent;
import com.sencha.gxt.widget.core.client.event.HideEvent.HideHandler;

public class MainPanel extends Composite {
	interface MyUiBinder extends UiBinder<Widget, MainPanel> {

	}

	@UiField Label welcomelabel;
	@UiField BorderLayoutContainer con;
	
	private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

	public MainPanel() {
		initWidget(uiBinder.createAndBindUi(this));
		//collapse the WEST region
		con.collapse(LayoutRegion.WEST);
		populateUsername();
	}
	
	private void populateUsername() {
		String username = getUsername();
		welcomelabel.setText(username);
	}
	
	public static native String getUsername()/*-{
    	return $wnd.getLoginUsername();
	}-*/; 
	
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
	}
}
