/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.dao.employee;

/**
 * EmployeeDaoTest
 *
 * TODO Write something about this class
 * 
 * @author Praveen
 * @version 1.0 2013
 **/


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

import com.media2359.euphoria.dao.employee.EmployeeDAO;
import com.media2359.euphoria.dao.project.PlatformDAO;
import com.media2359.euphoria.dao.project.ProjectDAO;
import com.media2359.euphoria.model.employee.Employee;
import com.media2359.euphoria.model.project.Platform;
import com.media2359.euphoria.model.project.Project;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext-model-test.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeDaoTest {
	@Autowired
	private EmployeeDAO employeeDao;
	
	/*@Autowired
	private PlatformDAO platformDao;*/
	private Logger log = Logger.getLogger(EmployeeDaoTest.class);
	
	@Test
	public void test1GetAllEmployees() {
		log.info("test1GetAllEmployees start...");
		List<Employee> employees = employeeDao.getAllEmployees();
		Assert.assertNotNull(employees);
		log.info("Number of Employees returned:"+employees.size());
		log.info("test1GetAllEmployees end...");
		
	}
	
	
	@Test
	public void test2getEmployeesByPlatform() {
		log.info("####test2getEmployeesByPlatform start...");
		Platform platform = new Platform();
		platform.setPlatformKey(Integer.valueOf(1));
		
		List<Employee> employees = employeeDao.getEmployeesByPlatform(platform);
		Assert.assertNotNull(employees);
		log.info("####Number of Employees by platform returned:"+employees.size());
		log.info("####test2getEmployeesByPlatform end...");
		
	}
}
