package com.userpost.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userpost.model.Address;

public interface AddressRepository extends JpaRepository<Address, String> {

	
}
