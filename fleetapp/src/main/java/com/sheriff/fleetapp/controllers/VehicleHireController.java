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

import com.sheriff.fleetapp.models.VehicleHire;
import com.sheriff.fleetapp.services.ClientService;
import com.sheriff.fleetapp.services.LocationService;
import com.sheriff.fleetapp.services.VehicleHireService;
import com.sheriff.fleetapp.services.VehicleService;

@Controller
public class VehicleHireController {
	
	@Autowired
	private VehicleHireService vehicleHireService;
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private LocationService locationService;
	
	@Autowired
	private VehicleService vehicleService;

	@GetMapping("/vehicleHire")
	public String getVehicleHire(Model model) {
		model.addAttribute("vehicleHires", vehicleHireService.getVehicleHires());
		model.addAttribute("vehicles", vehicleService.getVehicles());
		model.addAttribute("clients", clientService.getClient());
		model.addAttribute("locations", locationService.getLocation());
		return "vehicleHire";
	}
	
	@PostMapping("/vehicleHire/addNew")
	public String saveVehicleHire(VehicleHire vehicleHire) {
		vehicleHireService.saveVehicleHire(vehicleHire);
		return "redirect:/vehicleHire";
	}
	
	@RequestMapping("/vehicleHire/findById")
	@ResponseBody
	public Optional<VehicleHire> getVehicleHireById(int id) {
		return vehicleHireService.getVehicleHireById(id);
	}
	
	@RequestMapping(value = "/vehicleHire/update", method = {RequestMethod.GET, RequestMethod.PUT})
	public String updateVehicleHire(VehicleHire vehicleHire) {
		vehicleHireService.saveVehicleHire(vehicleHire);
		return "redirect:/vehicleHire";
	}
	
	@RequestMapping(value = "/vehicleHire/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String deleteVehicleHire(Integer id) {
		vehicleHireService.deleteVehicleHire(id);
		return "redirect:/vehicleHire";
	}
}
