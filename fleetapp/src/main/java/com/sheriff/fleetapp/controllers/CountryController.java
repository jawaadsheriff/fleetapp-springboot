package com.sheriff.fleetapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

	@RequestMapping("/country/findById")
	@ResponseBody
	public Optional<Country> getCountryById(int id) {
		return countryService.getCountryById(id);
	}

	@RequestMapping(value = "/country/update", method = {RequestMethod.GET, RequestMethod.PUT})
	public String updateCountry(Country country) {
		countryService.saveCountry(country);
		return "redirect:/country";
	}

	@RequestMapping(value = "/country/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String deleteCountry(Integer id) {
		countryService.deleteCountry(id);
		return "redirect:/country";
	}
}
