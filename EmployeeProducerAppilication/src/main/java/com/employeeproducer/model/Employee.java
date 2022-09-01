package com.employeeproducer.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

public class Employee {

	@Min(value = 10000,message="employee Id Should BE 5  Digits")
	private int employeeId;
	private String name;
	private String address;
	@Pattern(regexp="(0|91)?[7-9][0-9]{9}",message="mobile should be 10 digits")
	private String mobileNumber;
	@Pattern(regexp="[a-z][._a-z0-9]+@[a-z]+.[c][o][m]+$",message = "Email Should start with lowercase character and end with suffix .com")
	private String email;
	@Min(value=10000,message="greater than 10000")
	private int salary;
	private Credientials credientails;//establishing relation ship to credentials table
	
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Credientials getCredientails() {
		return credientails;
	}
	public void setCredientails(Credientials credientails) {
		this.credientails = credientails;
	}
	public Employee() {
		super();
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", address=" + address + ", mobileNumber="
				+ mobileNumber + ", email=" + email + ", salary=" + salary + ", credientails=" + credientails + "]";
	}
	public Employee(int employeeId, String name, String address, String mobileNumber, String email, int salary,
			Credientials credientails) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.salary = salary;
		this.credientails = credientails;
	}
	
	
}
