package com.media2359.euphoria.view.server.demo;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("service/EchoService")
public interface EchoService extends RemoteService {
	public String getMessage(String message);
}
