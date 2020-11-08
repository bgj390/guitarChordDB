/*package com.example.guitarChords.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.guitarChords.model.User;
import com.example.guitarChords.model.UserRepository;

@Controller
public class UserController {
	@Autowired
	private UserRepository repository;
	
	// Log in
	@RequestMapping("/")
	public String login() {
		return "login";
	}
	@GetMapping("/")
	public String showHome(User user) {
		return "registration_form";
	}
	
	@GetMapping("/registration_form")
	public String showRegistrationForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "registration_form";
	}
	
	@PostMapping("/save_user")
	public String saveUser(@ModelAttribute User user, Model model) {
		repository.save(user);
		model.addAttribute("users", repository.findAll());
		return "login";
	}
	
}*/
