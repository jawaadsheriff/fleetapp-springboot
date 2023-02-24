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

import com.sheriff.fleetapp.models.VehicleStatus;
import com.sheriff.fleetapp.services.VehicleStatusService;

@Controller
public class VehicleStatusController {

	@Autowired
	private VehicleStatusService vehicleStatusService;

	@GetMapping("/vehicleStatus")
	public String getVehicleStatus(Model model) {
		List<VehicleStatus> vehicleStatusList = vehicleStatusService.getVehicleStatus();
		model.addAttribute("vehicleStatuses", vehicleStatusList);
		return "vehicleStatus";
	}

	@PostMapping("/vehicleStatus/addNew")
	public String saveVehicleStatus(VehicleStatus vehicleStatus) {
		vehicleStatusService.saveVehicleStatus(vehicleStatus);
		return "redirect:/vehicleStatus";
	}

	@RequestMapping("/vehicleStatus/findById")
	@ResponseBody
	public Optional<VehicleStatus> getVehicleStatusById(int id) {
		return vehicleStatusService.getVehicleStatusById(id);
	}

	@RequestMapping(value = "/vehicleStatus/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String updateVehicleStatus(VehicleStatus vehicleStatus) {
		vehicleStatusService.saveVehicleStatus(vehicleStatus);
		return "redirect:/vehicleStatus";
	}

	@RequestMapping(value = "/vehicleStatus/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String deleteVehicleStatus(Integer id) {
		vehicleStatusService.deleteVehicleStatus(id);
		return "redirect:/vehicleStatus";
	}
}
