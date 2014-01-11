package com.media2359.euphoria.view.client.common;

import com.sencha.gxt.widget.core.client.info.Info;

public class NotificationBox {

	public static void info(String title, String message) {
		Info info = new Info();
		info.addStyleName("info-blue");
		info.display(title, message);
	}
	
	public static void success(String title, String message) {
		Info info = new Info();
		info.addStyleName("info-green");
		info.display(title, message);
	}

}
