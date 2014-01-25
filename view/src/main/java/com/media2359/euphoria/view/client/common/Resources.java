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

	@Source("approval.png")
	ImageResource approval();

	@Source("project.png")
	ImageResource project();

	@Source("gear.png")
	ImageResource gear();
	
	@Source("approvereq.png")
	ImageResource approve();
	
	@Source("reject.png")
	ImageResource reject();
	
	@Source("add_user.png")
	ImageResource adduser();
	
	@Source("add_project.png")
	ImageResource addproject();
	
	@Source("save.png")
	ImageResource save();
	
	@Source("addrow.png")
	ImageResource addrow();
	
	@Source("reset.png")
	ImageResource reset();
	
	@Source("approval_disabled.png")
	ImageResource disabled();
}
