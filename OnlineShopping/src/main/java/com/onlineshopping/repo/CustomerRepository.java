package com.onlineshopping.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineshopping.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
