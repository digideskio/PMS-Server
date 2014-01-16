package com.media2359.euphoria.view.client.common;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface Resources extends ClientBundle {
	public Resources INSTANCE = GWT.create(Resources.class);

	@Source("staff.png")
	ImageResource manager();

	@Source("dashboard.png")
	ImageResource dashboard();

	@Source("request.png")
	ImageResource request();

	@Source("approve.png")
	ImageResource approve();

	@Source("project.png")
	ImageResource project();

	@Source("gear.png")
	ImageResource gear();
}
