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
	private Logger log = Logger.getLogger(ProjectTeamDaoTest.class);
	
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
	
}

