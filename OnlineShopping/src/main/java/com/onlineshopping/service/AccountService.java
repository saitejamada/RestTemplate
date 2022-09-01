package com.onlineshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineshopping.model.Account;
import com.onlineshopping.repo.AccountRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository ar;
	
	public void saveAccount(Account a) {
		ar.save(a);
	}
	
	public Account getAccoont(int id) {
		return ar.findById(id).get();
	}
}
