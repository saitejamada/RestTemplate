package com.userpost.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.userpost.model.Posts;
import com.userpost.model.ResponseUsers;
import com.userpost.model.Users;
import com.userpost.repository.PostsRepository;
import com.userpost.repository.UserRepoistory;


@Service
public class UserService {
	
	private RestTemplate restTemplate;
	
	@Autowired
	UserRepoistory ur;
	@Autowired
	PostsRepository pr;

	public UserService(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}
	
	//this method will get the array of posts from url's and return the array.
		public Posts[] getPosts(){
			//defining the Post url's.
			String postUrl="https://jsonplaceholder.typicode.com/posts";
			//using the restTemplate calling the api's and saving them in array's
			Posts[] postList=restTemplate.getForObject(postUrl,Posts[].class);
			for (Posts posts : postList) {
				pr.save(posts);
			}
			return postList; 
			
		}
		
		//this method will get the array of users from url's and return the array.
		public Users[] getUsers(){
			//defining the User url's
			String userUrl="https://jsonplaceholder.typicode.com/users";
			//using the restTemplate calling the api's and saving them in array's
			Users[] userList=restTemplate.getForObject(userUrl, Users[].class);
			for (Users users : userList) {
				ur.save(users);
			}
			return userList;
		}
		public List<Users> getAllUsers(){
			return ur.findAll();
		}
		public List<Posts> getAllPosts(){
			return pr.findAll();
		}
		
		public List<ResponseUsers> getUsersPostsCount() {
			int count=0;
			List<ResponseUsers> responseList = new ArrayList<>();
			List<Users> usersList=getAllUsers();
			List<Posts> postList=getAllPosts();
			for(int i=0;i<usersList.size();i++){
				for(int j=0;j<postList.size();j++){
					if(usersList.get(i).getId() == postList.get(j).getUserId())
					count ++;
					}
				ResponseUsers res=new ResponseUsers(usersList.get(i).getId(),usersList.get(i).getName(),usersList.get(i).getUsername(),usersList.get(i).getEmail(),usersList.get(i).getAddress(),usersList.get(i).getPhone(),usersList.get(i).getWebsite(),usersList.get(i).getCompany(),count);
				responseList.add(res);
				count=0;
			}
			 return responseList;
		}
		public List<Users> getUsersByComany(String name){
			return ur.findByCompany(name);
		}
}
