package net.bozorgi.controller;

import java.util.List;

import javax.validation.Valid;

import net.bozorgi.dao.User;
import net.bozorgi.service.UsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	private UsersService usersService;
	
	@Autowired
	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}
	
	@RequestMapping("/login")
	public String showLogin(){
		return "login";
	}
	
	@RequestMapping("/denied")
	public String showDenied(){
		return "denied";
	}
	
	@RequestMapping("/loggedout")
	public String showLoggedOut(){
		return "loggedout";
	}
	
	
	@RequestMapping("/newaccount")
	public String showNewAccount(Model model){
		
		model.addAttribute("user", new User());
		return "newaccount";
	}
	
	
	@RequestMapping(value="/createaccount", method=RequestMethod.POST)
	public String createAccount(@Valid User user, BindingResult result){
		
		if(result.hasErrors()){
			return "newaccount";
		}
		
		user.setAuthority("ROLE_USER");
		user.setEnabled(true);
		
		if(usersService.exists(user.getUsername())){
			result.rejectValue("username", "DuplicateKey.user.username", "This username is already exist.");
			System.out.println("Duplicate username caught in if statement in LoginConroller class, createAccount method.");
			return "newaccount";
		}
		
		
		
		try {
			usersService.createUser(user);
		} catch (DuplicateKeyException e) {
			System.out.println("Duplicate username");
			result.rejectValue("username", "DuplicateKey.user.username", "This username is already exist.");
			return "newaccount";
		}
		
		
		System.out.println("CreateAccount method in LoginController is run.");
		return "accountcreated";
	}
	
	
	@RequestMapping("/admin")
	public String showAdmin(Model model){
		
		List<User> users = usersService.getAllUsers(); 
		model.addAttribute("users", users);
		
		return"admin";
	}
	
	
	
	
}
