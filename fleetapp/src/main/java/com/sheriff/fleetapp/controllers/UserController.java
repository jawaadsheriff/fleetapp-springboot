package com.sheriff.fleetapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.sheriff.fleetapp.models.User;
import com.sheriff.fleetapp.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/user")
	public String getUser() {
		return "user";
	}
	
	@PostMapping(value = "/user/addNew")
	public RedirectView addNewUser(User user, RedirectAttributes redirectAttributes) {
		userService.saveUser(user);
		RedirectView redirectView = new RedirectView("/login", true);
		redirectAttributes.addFlashAttribute("message", "You have successfully registered! You can now login!");
		return redirectView;
	}
}