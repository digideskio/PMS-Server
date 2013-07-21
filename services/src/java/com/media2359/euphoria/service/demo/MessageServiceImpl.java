package com.media2359.euphoria.service.demo; 

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.media2359.euphoria.dao.MessageDAO;
import com.media2359.euphoria.view.message.demo.EchoRequest;
import com.media2359.euphoria.view.message.demo.EchoResponse;
import com.media2359.euphoria.view.service.demo.MessageService;

import com.media2359.euphoria.view.util.*;
import java.util.*;
import java.io.*;
import java.net.*;


@Service("messageService") 
public class MessageServiceImpl implements MessageService { 
    
	 
	private final String token = "1c969665aabec2f312e8786fc441a0ad";
    @Autowired 
    private MessageDAO messageDAO; 
    private URL url;
	private HttpURLConnection conn;
	BufferedReader br;
	OutputStreamWriter wr;
	private String projectID,output,phaseID;
	
    @PostConstruct 
    public void init() throws Exception { 
    } 
    
    @PreDestroy 
    public void destroy() { 
    }

	@Override
	public String echoMessage(String name){
		return messageDAO.getData(name);
	}

	@Override
	public boolean addProjectToDB(String projectName) {
		return messageDAO.addProjectToDB(projectName);
	}

	@Override
	public boolean addPhaseToDB(String projectName, String phaseName) {
		return messageDAO.addPhaseToDB(projectName,phaseName);
	}

	@Override
	public boolean addTaskToDB(String projectName, String phaseName,
			String taskName) {
		return messageDAO.addTaskToDB(projectName,phaseName,taskName);
	}

	@Override
	public boolean deleteProjectFromDB(String projectName) {
		return messageDAO.deleteProjectFromDB(projectName);
	}

	@Override
	public boolean deletePhaseFromDB(String projectName, String phaseName) {
		return messageDAO.deleteProjectFromDB(projectName,phaseName);
	}

	@Override
	public boolean deleteTaskFromDB(String projectName, String phaseName,
			String taskName) {
		return messageDAO.deleteProjectFromDB(projectName,phaseName,taskName);
	}

	@Override
	public List<Project> getAllProjectsFromDB() {
		return messageDAO.getAllProjectsFromDB();
	}
		

	@Override
	public boolean addProjectToPivotal(String projectName) {
		
		try{
			url = new URL("http://www.pivotaltracker.com/services/v3/projects");
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestProperty("X-TrackerToken",token);
			conn.setRequestProperty("Content-type","application/xml");
			
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setReadTimeout(30000);
			conn.connect();
			
			wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write("<project><name>"+projectName+"</name><iteration_length type=\"integer\">2</iteration_length><point_scale>0,1,3,9,27</point_scale></project>");
			wr.flush();
			
			
			br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));
		 
			while ((output = br.readLine()) != null) {
				System.out.println(output);								
			}
			conn.disconnect();
		}catch(Exception e){
			e.printStackTrace();
		}
			
		
		System.out.println("***************************************************************************************");
		System.out.println();
		return true;
	}

	@Override
	public boolean addPhaseToPivotal(String projectName, String phaseName) {
		
		try{
			getProjectID(projectName);
			url = new URL("http://www.pivotaltracker.com/services/v3/projects/"+projectID+"/stories");
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestProperty("X-TrackerToken",token);
			conn.setRequestProperty("Content-type","application/xml");
			
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setReadTimeout(30000);
			conn.connect();
			
			wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write("<story><story_type>release</story_type><name>"+phaseName+"</name></story>");
			wr.flush();
			
			Thread.sleep(3000);
			br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));
		 
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
			conn.disconnect();
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("***************************************************************************************");
		System.out.println();
		return true;
	}

	@Override
	public boolean deletePhaseFromPivotal(String projectName, String phaseName) {
		
		try{
			getProjectID(projectName);
			getPhaseID(phaseName);
			url = new URL("http://www.pivotaltracker.com/services/v3/projects/"+projectID+"/stories/"+phaseID);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestProperty("X-TrackerToken",token);
			
			conn.setRequestMethod("DELETE");
			conn.setReadTimeout(30000);
			conn.connect();
		
			
			Thread.sleep(3000);
			br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));
		 
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		conn.disconnect();
		return true;
	}
	
	@Override
	public boolean deleteProjectFromPivotal(String projectName) {
//		try{
//			getProjectID(projectName);
//			url = new URL("http://www.pivotaltracker.com/services/v3/projects/"+projectID);
//			conn = (HttpURLConnection) url.openConnection();
//			conn.setRequestProperty("X-TrackerToken",token);
//			
//			conn.setRequestMethod("DELETE");
//			conn.setReadTimeout(30000);
//			conn.connect();
//		
//			
//			Thread.sleep(3000);
//			br = new BufferedReader(new InputStreamReader(
//					(conn.getInputStream())));
//		 
//			while ((output = br.readLine()) != null) {
//				System.out.println(output);
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//		}
		return true;
	}

	
	public void getProjectID(String name) throws Exception{
		
		try{
			url = new URL("http://www.pivotaltracker.com/services/v3/projects");
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestProperty("X-TrackerToken",token);
			
			conn.setRequestMethod("GET");
			conn.setReadTimeout(30000);
			conn.connect();
			
			br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));
			
			String projList = "";
			while ((output = br.readLine()) != null) {
				projList+=output;
				System.out.println(output);
			}
			
			projList = projList.substring(0,projList.indexOf("<name>"+name+"</name>"));
			projectID = projList.substring(projList.lastIndexOf("<id>")+"<id>".length(),projList.lastIndexOf("</id>"));
			
		}catch(Exception e){
			throw new Exception(e);
		}
		
		System.out.println("***************************************************************************************");
		System.out.println();
		
	}
	
	 public void getPhaseID(String name) throws Exception{
         
		 try{
	         url = new URL("http://www.pivotaltracker.com/services/v3/projects/"+projectID+"/stories");
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestProperty("X-TrackerToken",token);
			
			conn.setRequestMethod("GET");
			conn.setReadTimeout(30000);
			conn.connect();
			
			br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));
			
	             String input = "";
			while ((output = br.readLine()) != null) {
				System.out.println(output);
	                     input +=output;
			}
	             
	             input = input.substring(0,input.indexOf("<name>"+name));
	             phaseID = input.substring(input.lastIndexOf("<id type=\"integer\">")+"<id type=\"integer\">".length(),input.lastIndexOf("</id>"));
		 }catch(Exception e){
			 throw new Exception(e);
		 }
		System.out.println("***************************************************************************************");
		System.out.println();
     }
    
} 
