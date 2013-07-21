package com.media2359.euphoria.view.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.scheduling.config.TaskNamespaceHandler;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.media2359.euphoria.view.client.utils.ClientCallBack;
import com.media2359.euphoria.view.client.utils.ConfirmPopUp;
import com.media2359.euphoria.view.client.utils.InputPopUp;
import com.media2359.euphoria.view.client.utils.TreePopupMenu;
import com.media2359.euphoria.view.message.demo.EchoRequest;
import com.media2359.euphoria.view.message.demo.EchoResponse;
import com.media2359.euphoria.view.service.demo.MessageService;
import com.media2359.euphoria.view.service.demo.MessageServiceAsync;
import com.media2359.euphoria.view.util.*;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Euphoria implements EntryPoint,ClientCallBack, AsyncCallback<Boolean> {
	
	private static final String FIRST_NODE= "All Projects";
	public static final int ROOT_LEVEL=0,PROJECT_LEVEL=1, PHASE_LEVEL=2,TASK_LEVEL=3;
	private TreeNode currentNode=null;
	private int left,top;
	private final Tree projectTree = new Tree();
	
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final MessageServiceAsync messageService = GWT
			.create(MessageService.class);
	
	
	/**
	 * This is the entry point method.
	 */	

	
	public void onModuleLoad() {
		final Label errorLabel = new Label();

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel rootPanel = RootPanel.get("nameFieldContainer");
		
		SimplePanel treePanel = new SimplePanel();
		rootPanel.add(treePanel, 10, 83);
		treePanel.setSize("231px", "207px");
		RootPanel.get("nameFieldContainer").add(treePanel);
		Tree projectsTree = new Tree();
		treePanel.setWidget(projectsTree);
		
		projectsTree.setStyleName("projectsTree");
		projectsTree.setSize("100%", "100%");
		
		final TreeItem allProjects = new TreeNode(FIRST_NODE, ROOT_LEVEL);
		projectsTree.addItem(allProjects);
		
		messageService.getAllProjectsFromDB(new AsyncCallback<List<Project>>() {
			public void onFailure(Throwable caught) {
				System.err.println("Remote Procedure Call - Failure");
//				caught.printStackTrace();
			}


			@Override
			public void onSuccess(List<Project> result) {
				System.out.println("RPC Call Successful");
				TreeNode projectNode=null,phaseNode=null,taskNode=null;
				for(Project project:result){
					projectNode = new TreeNode(project.getName(),PROJECT_LEVEL);
					for(Phase phase:project.getPhases()){
						phaseNode = new TreeNode(phaseNode.getName(), PHASE_LEVEL);
						projectNode.addItem(phaseNode);
						for(Task task:phase.getTasks()){
							taskNode = new TreeNode(taskNode.getName(), TASK_LEVEL);
							phaseNode.addItem(taskNode);
						}
					}
					allProjects.addItem(projectNode);
				}
				
				if(allProjects.getChildCount()>0)
					allProjects.setSelected(true);
			}
		});		
		
		projectsTree.addSelectionHandler(new SelectionHandler<TreeItem>() {


			@Override
			public void onSelection(SelectionEvent<TreeItem> event) {
				if(event.getSelectedItem()!= null)
					HandleTreeSelection(event);					
			}
			
			
		});
		
		
	}
	
	
	private void addProject(String name){
		messageService.addProjectToDB(name, this);
		messageService.addProjectToPivotal(name, this);
	}
	
	
	private void addPhase(String name){
		messageService.addPhaseToDB(currentNode.getName(),name, this);
		messageService.addPhaseToPivotal(currentNode.getName(), name, this);
	}
	
	private void addTask(String name){
		messageService.addTaskToDB(((TreeNode)currentNode.getParentItem()).getName(),currentNode.getName(),name, this);		
	}
	
	private void deleteProject(){
		messageService.deleteProjectFromDB(currentNode.getName(), this);
		messageService.deleteProjectFromPivotal(currentNode.getName(), this);
	}
	
	
	private void deletePhase(){
		messageService.deletePhaseFromDB(((TreeNode)currentNode.getParentItem()).getName(),currentNode.getName(), this);
		messageService.deletePhaseFromPivotal(((TreeNode)currentNode.getParentItem()).getName(), currentNode.getName(), this);
	}
	
	private void deleteTask(){
		messageService.deleteTaskFromDB(((TreeNode)currentNode.getParentItem().getParentItem()).getName(),((TreeNode)currentNode.getParentItem()).getName(),currentNode.getName(), this);
	}


	@Override
	public void confirmCallBackForDelete(int action) {
		if(action == CONFIRM){			
			switch(currentNode.getLevel()){
			case PROJECT_LEVEL: deleteProject();break;
			case PHASE_LEVEL: deletePhase();break;
			case TASK_LEVEL: deleteTask();break;			
			}
			
			currentNode.getParentItem().removeItem(currentNode);
		}
			
	}

	@Override
	public void nameCallBackForAdding(int action,String name) {
		if(action == OK){			
			switch(currentNode.getLevel()){
			case ROOT_LEVEL: addProject(name);break;
			case PROJECT_LEVEL: addPhase(name);break;
			case PHASE_LEVEL: addTask(name);break;
			}
			
			currentNode.addItem(new TreeNode(name, currentNode.getLevel()+1));
			currentNode.setState(true);
		}
	}
	
	public void HandleTreeSelection(SelectionEvent<TreeItem> event){
		
		TreeNode selectedNode = (TreeNode) event.getSelectedItem();
		currentNode = selectedNode;
		TreePopupMenu popup = new TreePopupMenu(selectedNode.getLevel(),this);
		left  =selectedNode.getAbsoluteLeft()+selectedNode.getLevel()*15+90;
		top = selectedNode.getAbsoluteTop()+10;
		popup.setPopupPosition(left,top);
		popup.show();
		
	}

	@Override
	public void addOrDeleteCallBackFromTree(int action) {

		if(action == ADD){
			int level = currentNode.getLevel();
			String title = null;
			switch(level){
				case Euphoria.ROOT_LEVEL:title="Please Key-in project Name:";break;
				case Euphoria.PROJECT_LEVEL:title="Please Key-in Phase Name:";break;
				case Euphoria.PHASE_LEVEL:title="Please Key-in Task Name:";break;
				default:return;
			}
			
			InputPopUp popup = new InputPopUp(title, this);
			popup.center();
			popup.show();
		}
		else if(action == DELETE){
			ConfirmPopUp popup = new ConfirmPopUp("Please confirm you wish to delete '"+currentNode.getName()+"'", this);
			popup.center();
			popup.show();
		}
	}


	@Override
	public void onFailure(Throwable caught) {
		System.err.println("Remote Procedure Call - Failure");
		caught.printStackTrace();
	}


	@Override
	public void onSuccess(Boolean result) {
		System.out.println("Remote Procedure Call Success");
		
	}
}
