package com.media2359.euphoria.dao;

import java.util.*;

import org.springframework.stereotype.*;

import com.media2359.euphoria.view.util.*;
import java.util.*;

@Repository("messageDAO")
public class MessageDAO {
	StringBuffer sb;
	public String getData(String data) {
		return "This is a data returned from Database using iBATIS ="+data;
	}

	public boolean addProjectToDB(String projectName) {
		sb = new StringBuffer();
		sb.append("Project ")
		 .append(projectName)
		 .append(" added to DB");
		System.out.println(sb);
		return true;
	}

	public boolean addPhaseToDB(String projectName, String phaseName) {
		sb = new StringBuffer();
		sb.append("Phase ")
		  .append(phaseName)
		  .append("of Project ")
		 .append(projectName)
		 .append(" added to DB");
		System.out.println(sb);
		return true;
	}

	public boolean addTaskToDB(String projectName, String phaseName,
			String taskName) {
		sb = new StringBuffer();
		sb.append("Task ")
		.append(taskName)
		.append("of Phase ")
		  .append(phaseName)
		  .append("of Project ")
		 .append(projectName)
		 .append(" added to DB");
		System.out.println(sb);
		return true;
	}

	public boolean deleteProjectFromDB(String projectName) {
		sb = new StringBuffer();
		sb.append("Project ")
		 .append(projectName)
		 .append(" deleted from DB");
		System.out.println(sb);
		return true;
	}

	public boolean deleteProjectFromDB(String projectName, String phaseName) {
		sb = new StringBuffer();
		sb.append("Phase ")
		  .append(phaseName)
		  .append("of Project ")
		 .append(projectName)
		 .append(" deleted from DB");
		System.out.println(sb);
		return true;
	}

	public boolean deleteProjectFromDB(String projectName, String phaseName,
			String taskName) {
		sb = new StringBuffer();
		sb.append("Task ")
		.append(taskName)
		.append("of Phase ")
		  .append(phaseName)
		  .append("of Project ")
		 .append(projectName)
		 .append(" deleted from DB");
		System.out.println(sb);
		return true;
	}

	public List<Project> getAllProjectsFromDB() {
		
		List<Project> projects= new ArrayList<Project>();
		//get all the projects from list with all its phases and 
		//all its tasks from DB.
		//We keep it like it for prototype. Future, we can change it to
		//lazy loading of tree.
		// Sample below to create the lists.
		
		Project project1 = new Project("Project 1");
		Project project2 = new Project("Project 2");
		
		Phase phase11 = new Phase("Phase 11");
		Phase phase12 = new Phase("Phase 12");
		
		Phase phase21 = new Phase("Phase 12");
		Phase phase22 = new Phase("Phase 12");
		
		Task task111= new Task("Task 111");
		Task task112= new Task("Task 112");
		Task task121= new Task("Task 121");
		Task task122= new Task("Task 122");
		
		Task task211= new Task("Task 211");
		Task task212= new Task("Task 212");
		Task task221= new Task("Task 221");
		Task task222= new Task("Task 222");
		
		phase11.addTask(task111);
		phase11.addTask(task112);
		
		phase12.addTask(task121);
		phase12.addTask(task122);
		
		phase21.addTask(task211);
		phase21.addTask(task212);
		
		phase22.addTask(task221);
		phase22.addTask(task222);
		
		project1.addPhase(phase11);
		project1.addPhase(phase12);
		
		project2.addPhase(phase21);
		project2.addPhase(phase22);
		
		projects.add(project1);
		projects.add(project2);
		
		return projects;
		
	}
}
