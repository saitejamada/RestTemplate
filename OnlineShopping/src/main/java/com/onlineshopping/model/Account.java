package com.onlineshopping.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "account_onlineshopping")
public class Account {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int accountid;
	String billing_address;
	@OneToMany(cascade=CascadeType.ALL)
	List<Order> order;
	
	public int getAccountid() {
		return accountid;
	}
	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}
	public String getBilling_address() {
		return billing_address;
	}
	public void setBilling_address(String billing_address) {
		this.billing_address = billing_address;
	}
	public List<Order> getOrder() {
		return order;
	}
	public void setOrder(List<Order> order) {
		this.order = order;
	}
	public Account( String billing_address, List<Order> order) {
		super();
		this.billing_address = billing_address;
		this.order = order;
	}
	public Account() {
		super();
	}
	@Override
	public String toString() {
		return "Account [accountid=" + accountid + ", billing_address=" + billing_address + ", order=" + order + "]";
	}
}
