package com.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.onlineshopping.service.AccountService;

@Controller
public class AccountController {

	@Autowired
	AccountService as;
	
	@RequestMapping("/acc")
	public String account(Model m) {
		m.addAttribute("msg", "AccountController");
		return "Check";
	}
	
}
