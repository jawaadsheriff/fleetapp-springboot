package com.sheriff.fleetapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sheriff.fleetapp.models.Country;
import com.sheriff.fleetapp.services.CountryService;

@Controller
public class CountryController {
	
	@Autowired
	private CountryService countryService;
	
	@GetMapping("/country")
	public String getCountry(Model model) {
		List<Country> countryList = countryService.getCountries();
		model.addAttribute("countries", countryList);
		return "country";
	}

	@PostMapping("/country/addNew")
	public String addCountry(Country country) {
		countryService.saveCountry(country);
		return "redirect:/country";
	}
}
