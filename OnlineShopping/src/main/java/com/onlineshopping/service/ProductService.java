package com.onlineshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineshopping.model.Product;
import com.onlineshopping.repo.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository pr;
	
	public void saveproduct(Product p) {
		pr.save(p);
	}
	
	public Product getProduct(int id) {
		return pr.findById(id).get();
	}
}
