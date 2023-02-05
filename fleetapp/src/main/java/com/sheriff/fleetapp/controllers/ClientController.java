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

import com.sheriff.fleetapp.models.Client;
import com.sheriff.fleetapp.services.ClientService;
import com.sheriff.fleetapp.services.CountryService;
import com.sheriff.fleetapp.services.StateService;

@Controller
public class ClientController {
	
	@Autowired
	private ClientService clientService;

	@Autowired
	private CountryService countryService;
	
	@Autowired
	private StateService stateService;
	
	@GetMapping("/client")
	public String getClient(Model model) {
		model.addAttribute("clients", clientService.getClient());
		model.addAttribute("countries", countryService.getCountries());
		model.addAttribute("states", stateService.getStates());
		return "client";
	}
	
	@PostMapping("/client/addNew")
	public String saveClient(Client client) {
		clientService.saveClient(client);
		return "redirect:/client";
	}
	
	@RequestMapping("/client/findById")
	@ResponseBody
	public Optional<Client> findClientById(int id) {
		return clientService.findClientById(id);
	}
	
	@RequestMapping(value = "/client/update", method = {RequestMethod.GET, RequestMethod.PUT})
	public String updateClient(Client client) {
		clientService.saveClient(client);
		return "redirect:/client";
	}
	
	@RequestMapping(value = "/client/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String deleteClient(Integer id) {
		clientService.deleteClient(id);
		return "redirect:/client";
	}
}
