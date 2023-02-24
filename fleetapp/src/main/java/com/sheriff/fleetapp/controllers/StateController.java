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
import com.sheriff.fleetapp.models.State;
import com.sheriff.fleetapp.services.CountryService;
import com.sheriff.fleetapp.services.StateService;

@Controller
public class StateController {

	@Autowired
	private StateService stateService;

	@Autowired
	private CountryService countryService;

	@GetMapping("/state")
	public String getState(Model model) {
		List<State> statesList = stateService.getStates();
		model.addAttribute("states", statesList);
		List<Country> countryList = countryService.getCountries();
		model.addAttribute("countries", countryList);
		return "state";
	}

	@PostMapping("/state/addNew")
	public String saveState(State state) {
		stateService.saveState(state);
		return "redirect:/state";
	}

	@RequestMapping("/state/findById")
	@ResponseBody
	public Optional<State> getStateById(int id) {
		return stateService.getStateById(id);
	}

	@RequestMapping(value = "/state/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String updateState(State state) {
		stateService.saveState(state);
		return "redirect:/state";
	}

	@RequestMapping(value = "/state/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String deleteState(Integer id) {
		stateService.deleteState(id);
		return "redirect:/state";
	}
}
