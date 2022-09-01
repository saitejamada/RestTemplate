package com.onlineshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineshopping.model.Customer;
import com.onlineshopping.repo.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository cs;
	
	public void savecustomer(Customer c) {
		cs.save(c);
	}
	
	public Customer getCustomer(int id) {
		return cs.findById(id).get();
	}
	
}
