package com.userpost.controller;

import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.userpost.model.Posts;
import com.userpost.model.ResponseUsers;
import com.userpost.model.Users;
import com.userpost.service.UserService;

@RestController
public class UserPostsController {

	@Autowired
	UserService us;
	
	@PostConstruct
	void postconstruct() {
		us.getPosts();us.getUsers();
	}
	@GetMapping("/users")
	public List<Users> getUsersRest(){
		return us.getAllUsers();
	}
	
	@GetMapping("/posts")
	public List<Posts> getAllPosts(){
		return us.getAllPosts();
	}
	
	@GetMapping("/count")
	public List<ResponseUsers> getCount(){
		return us.getUsersPostsCount();
	}
	
	@GetMapping("/users/{name}")
	public List<Users> getCompanyUsers(@PathVariable("name") String name){
		return us.getUsersByComany(name);
		
	}
}
