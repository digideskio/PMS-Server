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

import java.util.Date;
import java.util.Set;

import com.media2359.euphoria.model.project.Platform;
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
	private String mandayRate;
	private String assignedOffice;
	private Date startDate;
	private Date endDate;
	private String status;
	
	Set<Platform> skills;
	Set<Role> roles;
	EmployeeLeavePlan leavePlan;


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

	public String getEmploymentType() {
		return employmentType;
	}

	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}
	
	

	/**
	 * @return the platForms
	 */
	public String getPlatForms() {
		return platForms;
	}

	/**
	 * @param platForms the platForms to set
	 */
	public void setPlatForms(String platForms) {
		this.platForms = platForms;
	}

	/**
	 * @return the mandayRate
	 */
	public String getMandayRate() {
		return mandayRate;
	}

	/**
	 * @param mandayRate the mandayRate to set
	 */
	public void setMandayRate(String mandayRate) {
		this.mandayRate = mandayRate;
	}

	/**
	 * @return the assignedOffice
	 */
	public String getAssignedOffice() {
		return assignedOffice;
	}

	/**
	 * @param assignedOffice the assignedOffice to set
	 */
	public void setAssignedOffice(String assignedOffice) {
		this.assignedOffice = assignedOffice;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**


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
