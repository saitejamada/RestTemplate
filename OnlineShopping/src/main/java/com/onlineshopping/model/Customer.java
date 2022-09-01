package com.onlineshopping.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer_onlineshopping")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int customer_id;
	String address;
	String phonenumber;
	String email;
	@OneToOne(cascade = CascadeType.ALL)
	Account account;
	@OneToOne(cascade = CascadeType.ALL)
	Web_user user;
	
	public Web_user getUser() {
		return user;
	}
	public void setUser(Web_user user) {
		this.user = user;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Customer( String address, String phonenumber, String email, Account account, Web_user user) {
		super();
		this.address = address;
		this.phonenumber = phonenumber;
		this.email = email;
		this.account = account;
		this.user = user;
	}
	public Customer() {
		super();
	}
	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", address=" + address + ", phonenumber=" + phonenumber
				+ ", email=" + email + ", account=" + account + ", user=" + user + "]";
	}
}
