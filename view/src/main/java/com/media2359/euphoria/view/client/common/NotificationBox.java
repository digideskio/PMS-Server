package com.media2359.euphoria.view.client.common;

import com.sencha.gxt.widget.core.client.info.Info;

public class NotificationBox {

	public static void info(String title, String message) {
		Info.display(title, message);
	}

}
