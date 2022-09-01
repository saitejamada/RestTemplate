package com.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.onlineshopping.service.PaymentService;

@Controller
public class PaymentController {

	@Autowired
	PaymentService ps;
	
	@RequestMapping("/pay")
	public String account(Model m) {
		m.addAttribute("msg", "PaymentController");
		return "Check";
	}
}
