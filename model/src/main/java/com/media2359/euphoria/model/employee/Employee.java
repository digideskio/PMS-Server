/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.model.employee;

import com.media2359.euphoria.view.dto.employee.EmployeeDTO;

/**
 * Employee
 *
 * TODO Write something about this class
 * 
 * @author Praveen
 * @version 1.0 2013
 **/

public class Employee {
	private String name;
	private String mobile;
	private String personalEmail;
	private String companyEmail;
	private String designation;
	private String platForms;
	private String employmentType;
	
	public Employee() {
		
	}
	
	public Employee(EmployeeDTO employeeDTO) {
		this.name = employeeDTO.getName();
		this.personalEmail = employeeDTO.getPersonalEmail();
		this.companyEmail = employeeDTO.getCompanyEmail();
		this.mobile = employeeDTO.getMobile();
		this.designation = employeeDTO.getDesignation();
		this.employmentType = employeeDTO.getEmploymentType();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPersonalEmail() {
		return personalEmail;
	}
	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}
	public String getCompanyEmail() {
		return companyEmail;
	}
	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getPlatForms() {
		return platForms;
	}
	public void setPlatForms(String platForms) {
		this.platForms = platForms;
	}
	public String getEmploymentType() {
		return employmentType;
	}
	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}
	/**
	 * TODO Write something about this method
	 *
	 * @returns EmployeeDTO
	 */
	public EmployeeDTO createEmployeeDTO() {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setName(getName());
		employeeDTO.setPersonalEmail(getPersonalEmail());
		employeeDTO.setCompanyEmail(getCompanyEmail());
		employeeDTO.setEmploymentType(getEmploymentType());
		employeeDTO.setMobile(getMobile());
		employeeDTO.setDesignation(getDesignation());
		return employeeDTO;
	}
}
