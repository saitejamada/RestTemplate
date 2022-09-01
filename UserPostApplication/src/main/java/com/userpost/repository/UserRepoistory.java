package com.userpost.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.userpost.model.Users;

public interface UserRepoistory extends JpaRepository<Users, Integer> {

	@Query(value = "select * from user_application where COMPANY_NAME = ?",nativeQuery = true)
	List<Users> findByCompany(String name);

}
