package com.sheriff.fleetapp.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sheriff.fleetapp.models.Contact;
import com.sheriff.fleetapp.services.ContactService;

@Controller
public class ContactController {
	
	@Autowired
	private ContactService contactService;

	@GetMapping("/contact")
	public String getContact(Model model) {
		model.addAttribute("contacts", contactService.getContact());
		return "contact";
	}
	
	@PostMapping("/contact/addNew")
	public String saveContact(Contact contact) {
		contactService.saveContact(contact);
		return "redirect:/contact";
	}
	
	@RequestMapping("/contact/findById")
	@ResponseBody
	public Optional<Contact> findContactById(int id) {
		return contactService.findContactById(id);
	}
	
	@RequestMapping(value = "/contact/update", method = {RequestMethod.GET, RequestMethod.PUT})
	public String updateContact(Contact contact) {
		contactService.saveContact(contact);
		return "redirect:/contact";
	}
	
	@RequestMapping(value = "/contact/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String deleteContact(Integer id) {
		contactService.deleteContact(id);
		return "redirect:/contact";
	}
}
