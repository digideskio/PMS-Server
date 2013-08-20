package com.media2359.euphoria.view.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.media2359.euphoria.view.client.main.MainPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Euphoria implements EntryPoint {
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		MainPanel mainPanel = new MainPanel();
		RootPanel.get().add(mainPanel);
	}
}
