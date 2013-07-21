package com.media2359.euphoria.view.service.demo;

import java.util.List;
import com.media2359.euphoria.view.util.Project;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.media2359.euphoria.view.message.demo.EchoRequest;
import com.media2359.euphoria.view.message.demo.EchoResponse;



/**
 * The async counterpart of <code>MessageService</code>.
 */
public interface MessageServiceAsync {
	void echoMessage(String input, AsyncCallback<String> callback);

	void addProjectToDB(String projectName, AsyncCallback<Boolean> callback);
	void addPhaseToDB(String projectName, String phaseName,
			AsyncCallback<Boolean> callback);
	void addTaskToDB(String projectName, String phaseName, String taskName,
			AsyncCallback<Boolean> callback);
	void deletePhaseFromDB(String projectName, String phaseName,
			AsyncCallback<Boolean> callback);
	void deleteProjectFromDB(String projectName, AsyncCallback<Boolean> callback);
	void deleteTaskFromDB(String projectName, String phaseName,
			String taskName, AsyncCallback<Boolean> callback);
	
	void getAllProjectsFromDB(AsyncCallback<List<Project>> callback);

	void addProjectToPivotal(String projectName, AsyncCallback<Boolean> callback);
	void addPhaseToPivotal(String projectName, String phaseName,
			AsyncCallback<Boolean> callback);
	void deletePhaseFromPivotal(String projectName, String phaseName,
			AsyncCallback<Boolean> callback);

	void deleteProjectFromPivotal(String projectName,
			AsyncCallback<Boolean> callback);
}
