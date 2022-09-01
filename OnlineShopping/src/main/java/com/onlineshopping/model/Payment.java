package com.onlineshopping.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="payment_onlineshopping")
public class Payment {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int payment_id;
	Date paiddate;
	int amount;
	
	public int getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}
	public Date getPaiddate() {
		return paiddate;
	}
	public void setPaiddate(Date paiddate) {
		this.paiddate = paiddate;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Payment( Date paiddate, int amount) {
		super();
		this.paiddate = paiddate;
		this.amount = amount;
	}
	public Payment() {
		super();
	}
	@Override
	public String toString() {
		return "Payment [payment_id=" + payment_id + ", paiddate=" + paiddate + ", amount=" + amount + "]";
	}
	
	
}
