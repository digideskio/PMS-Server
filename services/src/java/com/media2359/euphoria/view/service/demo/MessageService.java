package com.media2359.euphoria.view.service.demo;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.media2359.euphoria.view.message.demo.EchoRequest;
import com.media2359.euphoria.view.message.demo.EchoResponse;
import com.media2359.euphoria.view.util.*;

import java.util.*;


/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("services/messageService")
public interface MessageService extends RemoteService {
	
	String echoMessage(String input);
	
	boolean addProjectToDB(String projectName);
	boolean addPhaseToDB(String projectName,String phaseName);
	boolean addTaskToDB(String projectName, String phaseName,String taskName);
	boolean deleteProjectFromDB(String projectName);
	boolean deletePhaseFromDB(String projectName,String phaseName);
	boolean deleteTaskFromDB(String projectName, String phaseName,String taskName);
	
	List<Project> getAllProjectsFromDB();
	
	boolean addProjectToPivotal(String projectName);
	boolean addPhaseToPivotal(String projectName,String phaseName);
	boolean deletePhaseFromPivotal(String projectName, String phaseName);
	boolean deleteProjectFromPivotal(String projectName);
}
