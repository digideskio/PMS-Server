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
public class PlatformRequestDaoTest {
	@Autowired
	private PlatformRequestDAO platformRequestDAO;
	private Logger log = Logger.getLogger(PlatformRequestDaoTest.class);
	
	@Test
	public void test1findAllPlatformRequest() throws Exception{
		
		try{
		WeeklyManpowerRequest weeklyManpowerRequest = new WeeklyManpowerRequest();
		weeklyManpowerRequest.setWeeklyManpowerRequestKey(Integer.valueOf(1));
		
		List<PlatformRequest> platformRequests = 
				platformRequestDAO.findAllPlatformRequest(weeklyManpowerRequest);
		
		Assert.assertNotNull(platformRequests);
		log.info("####Count of Platform Request returned:"+ platformRequests.size());
		
		ListIterator iterator = platformRequests.listIterator();
		
		PlatformRequest platformRequest = iterator.hasNext()?(PlatformRequest) iterator.next():null;
		
		log.info("####PlatformRequst returned:"+ platformRequest.toString());
		}catch(Exception e){
			throw e;
		}
	}
	
}

