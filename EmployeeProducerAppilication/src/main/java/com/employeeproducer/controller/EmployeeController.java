package com.employeeproducer.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.employeeproducer.model.Credientials;
import com.employeeproducer.model.Employee;
import com.employeeproducer.service.EmployeeService;

@Controller
public class EmployeeController {

	
	@Autowired
	private EmployeeService employeeService;
	
	//adding Credientials in model class 
	@RequestMapping("/reguser")
	public String registerUser(Model m) {
		Credientials c=new Credientials();
		m.addAttribute("credential",c);
		return"RegisterUser";
	}
	//if validations are satisfied it will save the user else takes to registerUser  
	@RequestMapping("/save")
	public String insert(@Valid @ModelAttribute("credential") Credientials credential ,BindingResult bindingResult, Model m) throws Exception {
		if(bindingResult.hasErrors()) {
			return "RegisterUser";
		}
		else {
			employeeService.saveCredientials(credential);
			credential.setPassword(null);
			m.addAttribute("us",credential);
			return "login";
		}
	}
	//it will register Employee if validations are satisfied
	@PostMapping(value="/register")
	public String registerEmployee(@Valid  @ModelAttribute("reg") Employee emp,BindingResult bindingResult, Model model)
	{
		if(bindingResult.hasErrors()) {
			return "RegisterPageEmployee";
		} 
		else {
			System.out.println(emp);
			employeeService.postEmployee(emp);
			model.addAttribute("reg", emp);
			return "HomePage";
		}
	}
//	//it will validate the user and map accordingly user to homepage and admin to admin page
	@RequestMapping("/validateuser")
	public String validateuser(@ModelAttribute("us")Credientials c,Model m,HttpSession session) throws Exception{
		Credientials credientials=employeeService.getcredientails(c.getUserName());	
		if(credientials==null){
			m.addAttribute("msg", "No User Found With This username");
			return "login";
		}
		else if(c.getUserName().equals(credientials.getUserName())){
			session.setAttribute("name", credientials.getUserName());
			if(credientials.getRole().equals("ROLE_ADMIN")){
				employeeService.getEntity(c);
				 return "Admin";		
			}
			 else if(credientials.getRole().equals("ROLE_NORMAL")) {
				 c.setRole(credientials.getRole());
				 Employee emp=employeeService.getEmployee(credientials.getUserName(),c);
				 if(emp==null){
						Employee emp1=new Employee();
						c.setRole(credientials.getRole());
						emp1.setCredientails(c);
						m.addAttribute("reg", emp1);
						return "RegisterPageEmployee";
					}
					else{
						m.addAttribute("reg", emp);
						return "HomePage";
					}
				}
			 
		}
		else{
			m.addAttribute("msg", "password is not decrypted");
			return "login"; 
	 }
		return null;
	}
	//it will specific the employee details to update page
	@RequestMapping("/update/userName")
	public String updateEmployee(@RequestParam("userName") String c,Model m) {
		Credientials c1=employeeService.getcredientails(c);
		Employee emp=employeeService.getEmployee(c,c1);
		m.addAttribute("reg", emp);
		return "Update";
	}
	
	
	//it will update the employee details and return if validations are satisfied
	@RequestMapping("/updateEmp")
	public String update(@ModelAttribute("reg")Employee e,Model m){
		System.out.println("in update emp" +e);
		Employee emp=employeeService.updateEmployee(e);
		m.addAttribute("reg", emp);
		return "HomePage";
	}

	// it will give all the employee details
	@RequestMapping("/viewall")
	public String viewAllEmployees(Model m){
		List<Employee> list=employeeService.getAllEmployees();
		m.addAttribute("list", list);
		return "ViewAll";
	}
	//it will give all user details
	@RequestMapping("/viewUsers")
	public String viewAllUsers(Model m){
		List<Credientials> l=employeeService.getAllCredientails();
		m.addAttribute("list", l);
		return "View";
	}
	//it will give the login details
	@RequestMapping("/login")
	public String login(Model m){
		Credientials c=new Credientials();
		m.addAttribute("us",c);
		return "login";
	}
	@RequestMapping("/admin")
	public String goAdmin(Model m) {
		return "Admin";
	}
	@RequestMapping("/logout")
	public String logout(Model m){
		employeeService.logout();
		Credientials c=new Credientials();
		m.addAttribute("us",c);
		return "login";
	}
	
	
}
