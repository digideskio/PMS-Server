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
 * EmployeeLeaveDaoTest
 *
 * TODO Write something about this class
 * 
 * @author TY
 * @version 1.0 2013
 **/


import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.media2359.euphoria.model.employee.EmployeeLeave;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext-model-test.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeLeaveDaoTest {
	@Autowired
	private EmployeeLeaveDAO employeeLeaveDao;
	
	/*@Autowired
	private PlatformDAO platformDao;*/
	private Logger log = Logger.getLogger(EmployeeLeaveDaoTest.class);
	
	@Test
	public void test1GetAllLeaves() {
		log.info("####test1GetAllLeaves start...");
		List<EmployeeLeave> employeeLeaves = employeeLeaveDao.getAllLeaves();
		Assert.assertNotNull(employeeLeaves);
		log.info("####Number of EmployeeLeaves returned:"+employeeLeaves.size());
		log.info("####test1GetAllEmployees end...");
		
	}
	
	
	@Test
	public void test2GetAllLeavesByEmployee() {
		try{
			log.info("####test2GetAllLeavesByEmployee start...");
			Employee employee = new Employee();
			employee.setEmployeeKey(Integer.valueOf(1));
			Date startDate = (new SimpleDateFormat("yyyy-MM-dd")).parse("2013-12-30");
			Date endDate = (new SimpleDateFormat("yyyy-MM-dd")).parse("2014-01-05");
			
			List<EmployeeLeave> employeeLeaves = employeeLeaveDao.getAllLeavesByEmployee(employee, startDate, endDate);
			Assert.assertNotNull(employeeLeaves);
			log.info("####Number of EmployeeLeaves by platform returned:"+employeeLeaves.size());
			log.info("####Employee Leaves returned:"+employeeLeaves);
			log.info("####test2GetAllLeavesByEmployee end...");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
