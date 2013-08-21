package com.media2359.euphoria.view.client.main;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.Composite;

public class MainPanel extends Composite {
	interface MyUiBinder extends UiBinder<Widget, MainPanel> {

	}

	@UiField Label welcomelabel;
	
	private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

	public MainPanel() {
		initWidget(uiBinder.createAndBindUi(this));
		populateUsername();
	}
	
	private void populateUsername() {
		String username = getUsername();
		welcomelabel.setText(username);
	}
	
	public static native String getUsername()/*-{
    	return $wnd.getLoginUsername();
	}-*/; 
}
