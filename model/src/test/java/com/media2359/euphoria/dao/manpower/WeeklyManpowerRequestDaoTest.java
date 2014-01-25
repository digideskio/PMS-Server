/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.dao.manpower;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.text.SimpleDateFormat; 
import java.text.ParseException;


import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.media2359.euphoria.dao.project.*;
import com.media2359.euphoria.model.employee.Employee;
import com.media2359.euphoria.model.project.*;
import com.media2359.euphoria.model.manpower.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext-model-test.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WeeklyManpowerRequestDaoTest {
	@Autowired
	private WeeklyManpowerRequestDAO weeklyManpowerRequestDAO;
	private Logger log = Logger.getLogger(WeeklyManpowerRequestDaoTest.class);
	
	@Test
	public void test1findAllWklyMpowerRqstByProjectWeek() throws Exception{
		
		try{
		Date startDate = (new SimpleDateFormat("yyyy-MM-dd")).parse("2013-12-30");
		Date endDate = (new SimpleDateFormat("yyyy-MM-dd")).parse("2014-01-05");
		
		Project project = new Project();
		project.setId(Integer.valueOf(2));
		
		log.info("####startDate:"+startDate.toString());
		log.info("####endDate:"+endDate.toString());
		log.info("####project:"+project.toString());
		
		List<WeeklyManpowerRequest> weeklyManpowerRequests = 
				weeklyManpowerRequestDAO.findAllWklyMpowerRqstByProjectWeek(startDate, endDate, project);
		Assert.assertNotNull(weeklyManpowerRequests);
		log.info("####Count of Manpower Request returned:"+weeklyManpowerRequests.size());
		
		ListIterator iterator = weeklyManpowerRequests.listIterator();
		
		WeeklyManpowerRequest weeklyManpowerRequest = iterator.hasNext()?(WeeklyManpowerRequest) iterator.next():null;
		
		log.info("####WeeklyManpowerRequest returned:"+ weeklyManpowerRequest.toString());
		}catch(Exception e){
			throw e;
		}
	}
	
	@Test
	public void test2approveWeeklyManpowerRequest() throws Exception{
		log.info("####test2approveWeeklyManpowerRequest start...");
		try{
		WeeklyManpowerRequest weeklyManpowerRequest1 = new WeeklyManpowerRequest();
		weeklyManpowerRequest1.setWeeklyManpowerRequestKey(Integer.valueOf(2));
		weeklyManpowerRequest1.setApprovalStatus("A");
		
		weeklyManpowerRequestDAO.approveWeeklyManpowerRequest(weeklyManpowerRequest1);
		
		
		WeeklyManpowerRequest weeklyManpowerRequest2 = 
				weeklyManpowerRequestDAO.getManpowerRequest(Integer.valueOf(2));
		
		
		Assert.assertEquals("A", weeklyManpowerRequest2.getApprovalStatus());
		
		}catch(Exception e){
			throw e;
		}
		log.info("####test2approveWeeklyManpowerRequest end...");
	}
	
	@Test
	 public void test3addWeeklyManpowerRequest() throws Exception{
	  log.info("####test3addWeeklyManpowerRequest start...");
	  try{
	   PlatformRequest platformRequest = new PlatformRequest();
	   WeeklyManpowerRequest weeklyManpowerRequest = new WeeklyManpowerRequest();
	   Employee employee = new Employee();
	   Project project = new Project();
	   project.setId(Integer.valueOf(2));
	   Platform platform = new Platform();
	   
	   Date platformStartDate = (new SimpleDateFormat("yyyy-MM-dd")).parse("2014-01-28");
	   Date platformEndDate = (new SimpleDateFormat("yyyy-MM-dd")).parse("2014-01-29");
	   Date mPowerRqstStartDate = (new SimpleDateFormat("yyyy-MM-dd")).parse("2014-01-27");
	   Date mPowerRqstEndDate = (new SimpleDateFormat("yyyy-MM-dd")).parse("2014-01-31");
	   
	   platformRequest.setCreateById("TY");
	   platformRequest.setCreateTstamp(new Date());
	   employee.setEmployeeKey(Integer.valueOf(3));
	   platformRequest.setEmployee(employee);
	   platformRequest.setDuration(Float.valueOf(1));
	   platformRequest.setStartDate(platformStartDate);
	   platformRequest.setEndDate(platformEndDate);
	   platform.setPlatformKey(Integer.valueOf(1));
	   platformRequest.setPlatform(platform);
	   
	   weeklyManpowerRequest.setCreatedBy("TY");
	   weeklyManpowerRequest.setCreatedTstmp(new Date());
	   weeklyManpowerRequest.getPlatformRequests().add(platformRequest);
	   weeklyManpowerRequest.setProject(project);
	   weeklyManpowerRequest.setStartDate(mPowerRqstStartDate);
	   weeklyManpowerRequest.setEndDate(mPowerRqstEndDate);
	   weeklyManpowerRequest.setApprovalStatus("P");
	   
	   platformRequest.setWeeklyManpowerRequest(weeklyManpowerRequest);
	   
	   weeklyManpowerRequestDAO.addWeeklyManpowerRequest(weeklyManpowerRequest);
	   Integer maxSkey = weeklyManpowerRequestDAO.getMaxKey();
	  
	   WeeklyManpowerRequest weeklyManpowerRequest2 = weeklyManpowerRequestDAO.getManpowerRequest(maxSkey);
	   log.info("####weeklyManpowerRequest2:: " + weeklyManpowerRequest2);
	   
	   Assert.assertNotNull(weeklyManpowerRequest2);
	  
	  }catch(Exception e){
	   throw e;
	  }
	  log.info("####test3addWeeklyManpowerRequest end...");
	 }
	
	
	@Test
	 public void test4deleteWeeklyManpowerRequest() throws Exception{
	  log.info("####test4deleteWeeklyManpowerRequest start...");
	  try{
	   Project project = new Project();
	   project.setId(Integer.valueOf(2));
	   
	   List<WeeklyManpowerRequest> weeklyManpowerRequests = null;
	   Date mPowerRqstStartDate = (new SimpleDateFormat("yyyy-MM-dd")).parse("2014-01-27");
	   Date mPowerRqstEndDate = (new SimpleDateFormat("yyyy-MM-dd")).parse("2014-01-31");
	   
	  
	   weeklyManpowerRequestDAO.deleteWeeklyManpowerRequest(project, mPowerRqstStartDate, mPowerRqstEndDate);
	   weeklyManpowerRequests = weeklyManpowerRequestDAO.findAllWklyMpowerRqstByProjectWeek(mPowerRqstStartDate, mPowerRqstEndDate, project);
	   
	   Assert.assertEquals(0, weeklyManpowerRequests.size());
	  
	  }catch(Exception e){
	   throw e;
	  }
	  log.info("####test4deleteWeeklyManpowerRequest end...");
	 }
	
}

