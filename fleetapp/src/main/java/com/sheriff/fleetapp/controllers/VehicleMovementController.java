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

import com.sheriff.fleetapp.models.VehicleMovement;
import com.sheriff.fleetapp.services.LocationService;
import com.sheriff.fleetapp.services.VehicleMovementService;
import com.sheriff.fleetapp.services.VehicleService;

@Controller
public class VehicleMovementController {

	@Autowired
	private VehicleMovementService vehicleMovementService;

	@Autowired
	private VehicleService vehicleService;

	@Autowired
	private LocationService locationService;

	@GetMapping("/vehicleMovement")
	public String getVehicleMovement(Model model) {
		model.addAttribute("vehicleMovements", vehicleMovementService.getVehicleMovement());
		model.addAttribute("vehicles", vehicleService.getVehicles());
		model.addAttribute("locations", locationService.getLocation());
		return "vehicleMovement";
	}

	@PostMapping("/vehicleMovement/addNew")
	public String saveVehicleMovement(VehicleMovement vehicleMovement) {
		vehicleMovementService.saveVehicleMovement(vehicleMovement);
		return "redirect:/vehicleMovement";
	}

	@RequestMapping("/vehicleMovement/findById")
	@ResponseBody
	public Optional<VehicleMovement> getVehicleMovementById(int id) {
		return vehicleMovementService.getVehicleMovementById(id);
	}

	@RequestMapping(value = "/vehicleMovement/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String updateVehicleMovement(VehicleMovement vehicleMovement) {
		vehicleMovementService.saveVehicleMovement(vehicleMovement);
		return "redirect:/vehicleMovement";
	}

	@RequestMapping(value = "/vehicleMovement/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String deleteVehicleMovement(Integer id) {
		vehicleMovementService.deleteVehicleMovement(id);
		return "redirect:/vehicleMovement";
	}
}
