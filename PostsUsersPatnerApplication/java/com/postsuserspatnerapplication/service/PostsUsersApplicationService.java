package com.postsuserspatnerapplication.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.postsuserspatnerapplication.model.Posts;
import com.postsuserspatnerapplication.model.Response;
import com.postsuserspatnerapplication.model.Users;

@Service
public class PostsUsersApplicationService {

	private RestTemplate restTemplate;

	public PostsUsersApplicationService(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}
	
	//this method will get the array of posts from url's and return the array.
	public Posts[] getPosts(){
		//defining the Post url's.
		String postUrl="https://jsonplaceholder.typicode.com/posts";
		//using the restTemplate calling the api's and saving them in array's
		Posts[] postList=restTemplate.getForObject(postUrl,Posts[].class);
		return postList;
		
	}
	
	//this method will get the array of users from url's and return the array.
	public Users[] getUsers(){
		//defining the User url's
		String userUrl="https://jsonplaceholder.typicode.com/users";
		//using the restTemplate calling the api's and saving them in array's
		Users[] userList=restTemplate.getForObject(userUrl, Users[].class);
		return userList;
	}
	
	//this method will compare the Users userId and Posts userID and matching data will be returned
	public List<Response> comparePostsAndUsers(){
		//declaring the list of response to return
		List<Response> responseList=new ArrayList<Response>();		
		//this loop will iterate over user array and post array simultaneously 
		for(Users user:getUsers()) {
		    for(Posts post:getPosts()) {
		    	// if condition will compare the id's in both users and posts if both are equal it adds data to response class
				if(user.getId()==post.getId()) {
					Response response=new Response();
					response.setLat(user.getAddress().getGeo().getLat());
					response.setLng(user.getAddress().getGeo().getLng());
					response.setCompanyName(user.getCompany().getName());
					response.setTitle(post.getTitle());
					response.setBody(post.getBody());
					responseList.add(response);
				}
			}
		}
		return responseList;
	}

}
