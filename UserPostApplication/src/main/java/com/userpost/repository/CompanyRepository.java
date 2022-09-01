package com.userpost.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userpost.model.Company;

public interface CompanyRepository extends JpaRepository<Company, String>{

}
