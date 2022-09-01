package com.onlineshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineshopping.model.Order;
import com.onlineshopping.repo.OrderRepo;

@Service
public class OrderService {

	@Autowired
	OrderRepo or;
	
	public void saveOrder(Order o) {
		or.save(o);
	}
	public Order getOrder(int id) {
		return or.findById(id).get();
	}
}
