package com.onlineshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineshopping.model.Web_user;
import com.onlineshopping.repo.WebuserRepository;

@Service
public class Webuser_Service {

	@Autowired
	WebuserRepository ur;
	
	public void saveUser(Web_user user) {
		ur.save(user);
	}
	public Web_user getUser(String name) {
		return ur.findByUsername(name);
	}
}
