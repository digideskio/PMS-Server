/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.view.dto.employee;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import com.media2359.euphoria.view.dto.project.PlatformDTO;
/**
 * Employee
 *
 * TODO Write something about this class
 * 
 * @author Praveen
 * @version 1.0 2013
 **/

public class EmployeeDTO implements Serializable {
    
	private Integer employeeKey;
	private String name;
	private String mobile;
	private String personalEmail;
	private String companyEmail;
	private String designation;
	private Set<PlatformDTO> platFormDtos;
	private String employmentType;
	private String mandayRate;
	private String assignedOffice;
	private Date startDate;
	private Date endDate;
	private String status;
	private String createdById;
	private Date createTstamp; 
	
	
	public Integer getEmployeeKey() {
		return employeeKey;
	}
	public void setEmployeeKey(Integer employeeKey) {
		this.employeeKey = employeeKey;
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
	
	public Set<PlatformDTO> getPlatFormDtos() {
		return platFormDtos;
	}
	public void setPlatFormDtos(Set<PlatformDTO> platFormDtos) {
		this.platFormDtos = platFormDtos;
	}
	public String getEmploymentType() {
		return employmentType;
	}
	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
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
	
	
	public String getCreatedById() {
		return createdById;
	}
	public void setCreatedById(String createdById) {
		this.createdById = createdById;
	}
	public Date getCreateTstamp() {
		return createTstamp;
	}
	public void setCreateTstamp(Date createTstamp) {
		this.createTstamp = createTstamp;
	}
	@Override
	public String toString() {
		return "EmployeeDTO [employeeKey=" + employeeKey + ", name=" + name
				+ ", mobile=" + mobile + ", personalEmail=" + personalEmail
				+ ", companyEmail=" + companyEmail + ", designation="
				+ designation + ", platFormDtos=" + platFormDtos
				+ ", employmentType=" + employmentType + ", mandayRate="
				+ mandayRate + ", assignedOffice=" + assignedOffice
				+ ", startDate=" + startDate + ", endDate=" + endDate
				+ ", status=" + status + ", createdById=" + createdById
				+ ", createTstamp=" + createTstamp + "]";
	}


}
