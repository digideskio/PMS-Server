package com.media2359.euphoria.view.util;

import java.util.*;


public class Phase {
	String name;
	List <Task> tasks;
	
	public Phase(String name){
		this.name=name;
		tasks = new ArrayList<Task>();
	}
	
	public String getName(){
		return name;
	}
	
	public List<Task> getTasks(){
		return tasks;
	}
	
	public void addTask(Task task){
		tasks.add(task);
	}
}
