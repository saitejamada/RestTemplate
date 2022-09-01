package com.onlineshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineshopping.model.Payment;

import com.onlineshopping.repo.PaymentRepo;

@Service
public class PaymentService {

	@Autowired
	PaymentRepo pr;
	
	public void saveProduct(Payment p) {
		pr.save(p);
	}
	
	public Payment getPayment(int id) {
		return pr.findById(id).get();
	}
}
