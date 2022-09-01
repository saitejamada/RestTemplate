package com.userpost.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.userpost.model.ResponseUsers;
import com.userpost.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService us;
	
	@RequestMapping("/usersui")
	public String getAllUsers(Model m) {
		m.addAttribute("list",us.getUsersPostsCount());
		return "Users";
	}
	@RequestMapping("/companyname")
	public String getDetailsByCompany(Model m) {
		m.addAttribute("us", new ResponseUsers());
		return "Company";
	}
	@RequestMapping("/companyby")
	public String getDetails(Model m,@ModelAttribute("us")ResponseUsers res) {
		m.addAttribute("list", us.getUsersByComany(res.getCompany().getName()));
		return "NewFile";
	}
	
}
