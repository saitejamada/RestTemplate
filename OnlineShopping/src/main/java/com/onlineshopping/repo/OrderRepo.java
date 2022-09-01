package com.onlineshopping.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineshopping.model.Order;

public interface OrderRepo extends JpaRepository<Order, Integer> {

}
