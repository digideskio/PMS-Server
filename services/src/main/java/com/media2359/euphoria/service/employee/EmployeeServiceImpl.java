/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.service.employee;
/**
 * EmployeeServiceImpl
 *
 * TODO Write something about this class
 * 
 * @author Praveen
 * @version 1.0 2013
 **/

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.media2359.euphoria.dao.employee.EmployeeDAO;
import com.media2359.euphoria.dao.project.PlatformDAO;
import com.media2359.euphoria.model.employee.Employee;
import com.media2359.euphoria.model.project.Platform;
import com.media2359.euphoria.view.dto.employee.EmployeeDTO;
import com.media2359.euphoria.view.dto.project.PlatformDTO;
import com.media2359.euphoria.view.message.employee.EmployeeListRequest;
import com.media2359.euphoria.view.message.employee.EmployeeListResponse;
import com.media2359.euphoria.view.server.employee.EmployeeService;


@Service("EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDAO employeeDao;
	
	@Autowired
	private PlatformDAO platformDao;
	
	private final Logger log = Logger.getLogger(EmployeeServiceImpl.class);
	
	public EmployeeListResponse getAllEmployees(EmployeeListRequest request) {
		log.info("Received request :"+request);
		
		List<Employee> employees = employeeDao.getAllEmployees();
		EmployeeListResponse response =  new EmployeeListResponse();
		
		if(employees != null) {
			
			List<EmployeeDTO> respEmployees
			= new ArrayList<EmployeeDTO> ();
			
			for(Employee employee:employees){
				
				respEmployees.add(employee.createEmployeeDTO());
			}
			
			response.setEmployees(respEmployees);
		}
		
		return response;
		
 	}

	@Override
	public String addEmployee(EmployeeDTO employeeDto) {
		Employee employee = null;
		try{
			employee = new Employee(employeeDto);
			employee.setCreatedById("SYSTEM");
			employee.setCreateTstamp(new Date());
			employeeDao.addEmployee(employee);
		}catch(Exception exp){
			exp.printStackTrace();
			return "FAILED";
		}
		return "SUCCESS";
	}

	@Override
	public String modifyEmployee(EmployeeDTO employeeDto) {
		Employee employee = null;
		try{
			employee = new Employee(employeeDto);
			employee.setLastUpdById("SYSTEM");
			employee.setLastUpdTstamp(new Date());
			employeeDao.updateEmployee(employee);
		}catch(Exception exp){
			return "FAILED";
		}
		return "SUCCESS";
	}

	@Override
	public String deleteEmployee(EmployeeDTO employeeDto) {
		try{
			employeeDao.deleteEmployee(employeeDto.getEmployeeKey());
		}catch(Exception exp){
			return "FAILED";
		}
		return "SUCCESS";
	}

	@Override
	public EmployeeDTO getEmployeeDetails(EmployeeDTO employeeDto) {
		System.out.println("++++++ Employee Key +++++++"+employeeDto.getEmployeeKey());
		Employee employee = employeeDao.getEmployee(employeeDto.getEmployeeKey());
		EmployeeDTO respEmployee =  employee.createEmployeeDTO();
		
		return respEmployee;
	}

	@Override
	public Integer getMaxKey() {
		// TODO Auto-generated method stub
		return employeeDao.getMaxKey();
	}

	@Override
	public List<PlatformDTO> findAllPlatforms() {
		List<PlatformDTO> platformDTOList = new ArrayList<PlatformDTO>();
		List<Platform> platformList = platformDao.findAllPlatforms();
		for(Platform platform :platformList){
			PlatformDTO platformDTO = platform.createPlatformDTO();
			platformDTOList.add(platformDTO);
		}
		return platformDTOList;
		
	}

	@Override
	public List<EmployeeDTO> getEmployeesByPlatform(PlatformDTO platformDTO) {
		List<EmployeeDTO> employeeDtoList = new ArrayList<EmployeeDTO>();
		
		List<Employee> employeeList = employeeDao.getEmployeesByPlatform(new 
				Platform(platformDTO));
		for(Employee employee : employeeList){
			employeeDtoList.add(employee.createEmployeeDTO());
		}
		return employeeDtoList;
	}
	
	@Override
	public List<EmployeeDTO> getEmployeesByRole(String role) {
		List<EmployeeDTO> employeeDtoList = new ArrayList<EmployeeDTO>();
		
		List<Employee> employeeList = employeeDao.getEmployeesByRole(role);
		for(Employee employee : employeeList){
			employeeDtoList.add(employee.createEmployeeDTO());
		}
		return employeeDtoList;
	}
}
