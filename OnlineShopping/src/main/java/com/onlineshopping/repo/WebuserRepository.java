package com.onlineshopping.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineshopping.model.Web_user;

public interface WebuserRepository extends JpaRepository<Web_user, String> {

	Web_user findByUsername(String name);

}
