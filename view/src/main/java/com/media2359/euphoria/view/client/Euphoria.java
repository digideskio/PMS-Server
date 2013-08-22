package com.media2359.euphoria.view.client;


import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.RootPanel;
import com.media2359.euphoria.view.client.main.MainPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Euphoria implements EntryPoint, UncaughtExceptionHandler {
	Logger log = Logger.getLogger("EuphoriaLogger");
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		//First remove the loading message
		DOM.setInnerHTML(RootPanel.get("loading").getElement(), ""); 
		
		//Register ourselves to handle uncaught exceptions
		GWT.setUncaughtExceptionHandler(this);
		
		//Now starting the screens
		log.info("Loading module");
		MainPanel mainPanel = new MainPanel();
		RootPanel.get().add(mainPanel);
	}

	@Override
	public void onUncaughtException(Throwable e) {
		log.log(Level.SEVERE, "Received uncaught exception", e); 
	}
}
