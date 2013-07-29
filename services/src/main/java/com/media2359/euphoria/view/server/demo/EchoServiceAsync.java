package com.media2359.euphoria.view.server.demo;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface EchoServiceAsync {
	public void getMessage(String message, AsyncCallback<String> callback);
}
