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

import javax.persistence.Column;

import com.media2359.euphoria.model.employee.Employee;
import com.media2359.euphoria.model.user.Role;
import com.media2359.euphoria.view.dto.project.PlatformDTO;
/**
 * RoleDTO
 *
 * TODO Write something about this class
 * 
 * @author TY
 * @version 1.0 2013
 **/

public class RoleDTO implements Serializable {
    
	private Integer roleKey;
	private String roleId;
	private String roleName;
	
	
	public Integer getRoleKey() {
		return roleKey;
	}
	public void setRoleKey(Integer roleKey) {
		this.roleKey = roleKey;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	@Override
	public String toString() {
		return "RoleDTO [roleKey=" + roleKey + ", roleId=" + roleId
				+ ", roleName=" + roleName + "]";
	}
	
	
	
}
