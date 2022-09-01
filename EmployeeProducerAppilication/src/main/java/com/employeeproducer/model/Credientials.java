package com.employeeproducer.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Credientials {

	@Size(min = 5,message="UserName Should Be Atleast 6 characters")
	private String userName;//primary key
	private String password;
	private String role;
	
	@Override
	public String toString() {
		return "Credientials [userName=" + userName + ", password=" + password + ", role=" + role + "]";
	}

	public Credientials(@NotNull @Size(min = 5, message = "UserName Should Be Atleast 6 characters") String userName,
			String password, String role) {
		super();
		this.userName = userName;
		this.password = password;
		this.role = role;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Credientials() {
		super();
	}
		
}
