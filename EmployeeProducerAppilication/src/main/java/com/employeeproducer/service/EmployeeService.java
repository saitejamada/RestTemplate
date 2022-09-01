package com.employeeproducer.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.employeeproducer.model.Credientials;
import com.employeeproducer.model.Employee;
import com.employeeproducer.model.JwtResponse;


import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;


@Service
public class EmployeeService {

	RestTemplate template;
	
	private  String realToken;

	public EmployeeService(RestTemplate template) {
		super();
		this.template = template;
	}
	public Credientials getcredientails( String username) {
		String url="http://localhost:8080/credientails/"+username;
		return template.getForObject(url, Credientials.class);
	}
	public Employee updateEmployee(Employee e) {
		HttpEntity<?> request=new HttpEntity<>(e,getEntity(e.getCredientails()).getHeaders());
		String url="http://localhost:8080/employee";
		ResponseEntity<?> response=template.exchange(url,HttpMethod.PUT,request,Employee.class);
		Employee e1= (Employee) response.getBody();
		System.out.println("update employee servic eclass "+e1);
		return e1;
	}
	
	public List<Employee> getAllEmployees(){
		Credientials c = null;
		HttpEntity<String> req=getEntity(c);
		String url="http://localhost:8080/employee";
		ResponseEntity<Employee[]> response=template.exchange(url,HttpMethod.GET,req,Employee[].class);
		Employee[] e=response.getBody();
		return Arrays.asList(e);
	}
	public List<Credientials> getAllCredientails(){
		String url="http://localhost:8080/credientails";
		Credientials[] list=template.getForObject(url, Credientials[].class);
		return Arrays.asList(list);
	}
	public void saveCredientials(Credientials c) {
		String url="http://localhost:8080/credientails";
		template.postForEntity(url, c, Credientials.class);
	}
	public ResponseEntity<JwtResponse> getToken(Credientials c) {
		System.out.println("in get token");
		String url="http://localhost:8080/signin";
		return template.postForEntity(url,c,JwtResponse.class);
	}
	
	public HttpEntity<String> getEntity(Credientials c){
		System.out.println("in get entity method "+realToken);
		if( realToken==null) {
			System.out.println("in if condition going to invoke token method");
			ResponseEntity<JwtResponse> token=getToken(c);
			realToken="Bearer "+token.getBody();
		}		
		HttpHeaders headers=new HttpHeaders();
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Accept",MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", realToken);
		HttpEntity<String> request=new HttpEntity<>(headers);
		return request;	
	}
	public Employee getEmployee(String name,Credientials c) {
		HttpEntity<String> req=getEntity(c);
		String url="http://localhost:8080/employee/"+name;
		ResponseEntity<?> response=template.exchange(url,HttpMethod.GET,req,Employee.class);
		return (Employee) response.getBody();
	}

	public Employee postEmployee(Employee e) {
		HttpEntity<?> request=new HttpEntity<>(e, getEntity(e.getCredientails()).getHeaders());
		String url="http://localhost:8080/employee";
		ResponseEntity<?> response=template.exchange(url,HttpMethod.POST,request,Employee.class);
		return (Employee) response.getBody();
	}
	public void logout() {
		realToken=null;
	}
}
