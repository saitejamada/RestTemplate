package com.userpost.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "user_application")
public class Users {

	@Id
	private int id;
	private String name;
	private String username;
	private String email;
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	private String phone;
	private String website;
	@OneToOne(cascade = CascadeType.ALL)
	private Company company;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Users(int id, String name, String userName, String email, Address address, String phone, String website,
			Company company) {
		super();
		this.id = id;
		this.name = name;
		this.username = userName;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.website = website;
		this.company = company;
	}
	public Users() {
		super();
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", userName=" + username + ", email=" + email + ", address="
				+ address + ", phone=" + phone + ", website=" + website + ", company=" + company + "]";
	}
	
}
