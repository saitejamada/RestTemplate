package com.onlineshopping.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "web_user")
public class Web_user {

	@Id
	String username;
	String password;
	String role;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public Web_user(String username, String password, String role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}
	public Web_user() {
		super();
	}
	@Override
	public String toString() {
		return "Web_user [username=" + username + ", password=" + password + ", role=" + role + "]";
	}
	
	
}
