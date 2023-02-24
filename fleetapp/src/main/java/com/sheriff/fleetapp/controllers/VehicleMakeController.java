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

import com.sheriff.fleetapp.models.VehicleMake;
import com.sheriff.fleetapp.services.VehicleMakeService;

@Controller
public class VehicleMakeController {

	@Autowired
	private VehicleMakeService vehicleMakeService;

	@GetMapping("/vehicleMake")
	public String getVehicleMake(Model model) {
		List<VehicleMake> vehicleMakeList = vehicleMakeService.getVehicleMake();
		model.addAttribute("vehicleMakes", vehicleMakeList);
		return "vehicleMake";
	}

	@PostMapping("/vehicleMake/addNew")
	public String saveVehicleMake(VehicleMake vehicleMake) {
		vehicleMakeService.saveVehicleMake(vehicleMake);
		return "redirect:/vehicleMake";
	}

	@RequestMapping("/vehicleMake/findById")
	@ResponseBody
	public Optional<VehicleMake> getVehicleMakeById(int id) {
		return vehicleMakeService.getVehicleMakeById(id);
	}

	@RequestMapping(value = "/vehicleMake/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String updateVehicleMake(VehicleMake vehicleMake) {
		vehicleMakeService.saveVehicleMake(vehicleMake);
		return "redirect:/vehicleMake";
	}

	@RequestMapping(value = "/vehicleMake/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String deleteVehicleMake(Integer id) {
		vehicleMakeService.deleteVehicleMakeById(id);
		return "redirect:/vehicleMake";
	}
}
