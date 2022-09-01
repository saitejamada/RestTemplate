package com.onlineshopping.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineshopping.model.Payment;

public interface PaymentRepo extends JpaRepository<Payment,Integer> {

}
