/**************************************************************************
 * Copyright (c) 2013 2359 Media Pvt Ltd
 *
 * NOTICE:  All information contained herein is, and remains the 
 * property of 2359 Media Pvt Ltd and its suppliers, if any. 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from 2359 Media Pvt Ltd
 ***************************************************************************/
package com.media2359.euphoria.view.dto.user;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import com.media2359.euphoria.model.employee.Employee;
import com.media2359.euphoria.model.user.Role;
import com.media2359.euphoria.view.dto.project.PlatformDTO;
/**
 * UserDTO
 *
 * TODO Write something about this class
 * 
 * @author Praveen
 * @version 1.0 2013
 **/

public class UserDTO implements Serializable {
    
	private Integer userKey;
	private String userId;
	private String userName;
	private Employee employee;
	private Set<RoleDTO> roleDtos;
	private String createdById ;
	private Date createTstamp;
	public Integer getUserKey() {
		return userKey;
	}
	public void setUserKey(Integer userKey) {
		this.userKey = userKey;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public Set<RoleDTO> getRoleDtos() {
		return roleDtos;
	}
	public void setRoleDtos(Set<RoleDTO> roleDtos) {
		this.roleDtos = roleDtos;
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
		return "UserDTO [userKey=" + userKey + ", userId=" + userId
				+ ", userName=" + userName + ", employee=" + employee
				+ ", createdById=" + createdById + ", createTstamp="
				+ createTstamp + "]";
	}

	
}
