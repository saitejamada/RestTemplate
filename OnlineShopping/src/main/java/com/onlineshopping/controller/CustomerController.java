package com.onlineshopping.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.onlineshopping.model.Account;
import com.onlineshopping.model.Customer;
import com.onlineshopping.model.Order;
import com.onlineshopping.model.Payment;
import com.onlineshopping.model.Product;
import com.onlineshopping.model.Web_user;
import com.onlineshopping.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	CustomerService cs;
	
	@RequestMapping("/cus")
	public String account(Model m) {
		m.addAttribute("msg", "Customer Controller");
		return "Check";
	}
	@PostConstruct
	void postconstruct() {
		List<Order> list=new ArrayList<>();
		list.add(new Order(false, "nzb", new Payment(new Date(2021, 7, 11),5500),new Product("tv", 50000)));
		list.add(new Order(false, "mopal", new Payment(new Date(2020,10, 23),4000),new Product("laptop", 84000)));
		Customer c=new Customer();
		c.setAddress("hyderadad");c.setPhonenumber("8499995950");c.setEmail("mada@gmail.com");
		c.setAccount(new Account("nzb",list));
		c.setUser(new Web_user("saiteja","sai","normal"));
		cs.savecustomer(c);
	}
}
