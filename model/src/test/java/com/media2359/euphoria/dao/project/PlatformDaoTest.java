/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.dao.project;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.media2359.euphoria.dao.project.ProjectDAO;
import com.media2359.euphoria.model.project.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext-model-test.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class PlatformDaoTest {
	@Autowired
	private PlatformDAO platformDao;
	private Logger log = Logger.getLogger(PlatformDaoTest.class);
	
	@Test
	public void test1FindAllPlatforms() {
		log.info("####test1FindAllPlatforms start...");
		List<Platform> platforms = platformDao.findAllPlatforms();
		Assert.assertNotNull(platforms);
		log.info("Number of projects returned:"+platforms.size());
		log.info("####test1FindAllPlatforms end...");
		
	}
}

