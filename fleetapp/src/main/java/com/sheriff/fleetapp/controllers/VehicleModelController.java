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

import com.sheriff.fleetapp.models.VehicleModel;
import com.sheriff.fleetapp.services.VehicleModelService;

@Controller
public class VehicleModelController {
	
	@Autowired
	private VehicleModelService vehicleModelService;

	@GetMapping("/vehicleModel")
	public String getVehicleModel(Model model) {
		List<VehicleModel> vehicleModelList = vehicleModelService.getVehicleModel();
		model.addAttribute("vehicleModels", vehicleModelList);
		return "vehicleModel";
	}
	
	@PostMapping("/vehicleModel/addNew")
	public String saveVehicleModel(VehicleModel vehicleModel) {
		vehicleModelService.saveVehicleModel(vehicleModel);
		return "redirect:/vehicleModel";
	}
	
	@RequestMapping("/vehicleModel/findById")
	@ResponseBody
	public Optional<VehicleModel> getVehicleModelById(int id) {
		return vehicleModelService.getVehicleModelById(id);
	}
	
	@RequestMapping(value = "/vehicleModel/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String updateVehicleModel(VehicleModel vehicleModel) {
		vehicleModelService.saveVehicleModel(vehicleModel);
		return "redirect:/vehicleModel";
	}
	
	@RequestMapping(value = "/vehicleModel/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String deleteVehicleModel(Integer id) {
		vehicleModelService.deleteVehicleModel(id);
		return "redirect:/vehicleModel";
	}
}
