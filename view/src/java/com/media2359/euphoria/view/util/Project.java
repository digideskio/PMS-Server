package com.media2359.euphoria.view.util;

import java.util.*;

public class Project {
	String name;
	List <Phase> phases;
	
	public Project(String name){
		this.name=name;
		phases = new ArrayList<Phase>();
	}
	
	public String getName(){
		return name;
	}
	
	public List<Phase> getPhases(){
		return phases;
	}
	
	public void addPhase(Phase phase){
		phases.add(phase);
	}
}
