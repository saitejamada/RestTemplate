package com.onlineshopping.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineshopping.model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{

}
