package com.userpost.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userpost.model.Posts;

public interface PostsRepository extends JpaRepository<Posts, Integer>{

}
