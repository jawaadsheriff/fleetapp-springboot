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

import com.sheriff.fleetapp.models.VehicleType;
import com.sheriff.fleetapp.services.VehicleTypeService;

@Controller
public class VehicleTypeController {

	@Autowired
	private VehicleTypeService vehicleTypeService;

	@GetMapping("/vehicleType")
	public String getVehicleType(Model model) {
		List<VehicleType> vehicleTypeList = vehicleTypeService.getVehicleType();
		model.addAttribute("vehicleTypes", vehicleTypeList);
		return "vehicleType";
	}

	@PostMapping("/vehicleType/addNew")
	public String saveVehicleType(VehicleType vehicleType) {
		vehicleTypeService.saveVehicleType(vehicleType);
		return "redirect:/vehicleType";
	}

	@RequestMapping("/vehicleType/findById")
	@ResponseBody
	public Optional<VehicleType> getVehicleTypeById(int id) {
		return vehicleTypeService.getVehicleTypeById(id);
	}

	@RequestMapping(value = "/vehicleType/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String updateVehicleType(VehicleType vehicleType) {
		vehicleTypeService.saveVehicleType(vehicleType);
		return "redirect:/vehicleType";
	}

	@RequestMapping(value = "/vehicleType/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String deleteVehicleType(Integer id) {
		vehicleTypeService.deleteVehicleType(id);
		return "redirect:/vehicleType";
	}
}
