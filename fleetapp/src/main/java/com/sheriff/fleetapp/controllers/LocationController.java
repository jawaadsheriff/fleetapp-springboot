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
import com.sheriff.fleetapp.models.Location;
import com.sheriff.fleetapp.models.State;
import com.sheriff.fleetapp.services.CountryService;
import com.sheriff.fleetapp.services.LocationService;
import com.sheriff.fleetapp.services.StateService;

@Controller
public class LocationController {

	@Autowired
	private LocationService locationService;
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private StateService stateService;
	
	@GetMapping("/location")
	public String getLocation(Model model) {
		List<Location> locationList = locationService.getLocation();
		List<Country> countryList = countryService.getCountries();
		List<State> stateList = stateService.getStates();
		model.addAttribute("locations", locationList);
		model.addAttribute("countries", countryList);
		model.addAttribute("states", stateList);
		return "location";
	}
	
	@PostMapping("/location/addNew")
	public String saveLocation(Location location) {
		locationService.saveLocation(location);
		return "redirect:/location";
	}
	
	@GetMapping("/location/findById")
	@ResponseBody
	public Optional<Location> getLocationById(int id) {
		return locationService.getLocationById(id);
	}
	
	@RequestMapping(value = "/location/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String updateLocation(Location location) {
		locationService.saveLocation(location);
		return "redirect:/location";
	}
	
	@RequestMapping(value = "/location/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String deleteLocation(Integer id) {
		locationService.deleteLocationById(id);
		return "redirect:/location";
	}
}
