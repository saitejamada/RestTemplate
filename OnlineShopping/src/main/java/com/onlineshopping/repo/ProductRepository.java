package com.onlineshopping.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineshopping.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer > {

}
