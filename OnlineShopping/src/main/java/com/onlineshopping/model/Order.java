package com.onlineshopping.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_onlineshopping")
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	boolean shipped;
	String shipping_address;
	@OneToOne(cascade = CascadeType.ALL)
	Payment payment;
	@OneToOne(cascade = CascadeType.ALL)
	Product product;

	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isShipped() {
		return shipped;
	}
	public void setShipped(boolean shipped) {
		this.shipped = shipped;
	}
	public String getShipping_address() {
		return shipping_address;
	}
	public void setShipping_address(String shipping_address) {
		this.shipping_address = shipping_address;
	}
	public Order( boolean shipped, String shipping_address, Payment payment, Product product) {
		super();	
		this.shipped = shipped;
		this.shipping_address = shipping_address;
		this.payment = payment;
		this.product = product;
	}
	public Order() {
		super();
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", shipped=" + shipped + ", shipping_address=" + shipping_address + ", payment="
				+ payment + ", product=" + product + "]";
	}
	
}
