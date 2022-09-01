package com.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.onlineshopping.service.Webuser_Service;

@Controller
public class WebuserController {

	@Autowired
	Webuser_Service ws;
	
	@RequestMapping("/web")
	public String account(Model m) {
		m.addAttribute("msg", "AccountController");
		return "Check";
	}
	
	
}
