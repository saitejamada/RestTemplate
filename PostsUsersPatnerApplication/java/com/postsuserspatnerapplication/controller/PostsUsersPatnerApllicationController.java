package com.postsuserspatnerapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.postsuserspatnerapplication.model.Response;
import com.postsuserspatnerapplication.service.PostsUsersApplicationService;

@RestController
public class PostsUsersPatnerApllicationController {

	@Autowired
	 PostsUsersApplicationService service;
	
	@GetMapping("/response")//when url hits it gives the list response as response
	public List<Response> getResponse(){
		return service.comparePostsAndUsers();
	}
}
