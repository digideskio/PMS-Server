package com.media2359.euphoria.dao.user;

public enum Role {
	VP("VP"), MANAGER("PM"), USER("USER");
	 
	private String roleCode;
 
	private Role(String s) {
		roleCode = s;
	}
 
	public String getCode() {
		return roleCode;
	}
}
