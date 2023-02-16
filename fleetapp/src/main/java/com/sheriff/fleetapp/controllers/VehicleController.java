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

import com.sheriff.fleetapp.models.Vehicle;
import com.sheriff.fleetapp.services.EmployeeService;
import com.sheriff.fleetapp.services.LocationService;
import com.sheriff.fleetapp.services.VehicleMakeService;
import com.sheriff.fleetapp.services.VehicleModelService;
import com.sheriff.fleetapp.services.VehicleService;
import com.sheriff.fleetapp.services.VehicleStatusService;
import com.sheriff.fleetapp.services.VehicleTypeService;

@Controller
public class VehicleController {
	
	@Autowired private VehicleService vehicleService;
	@Autowired private VehicleTypeService vehicleTypeService;
	@Autowired private VehicleMakeService vehicleMakeService;
	@Autowired private VehicleStatusService vehicleStatusService;
	@Autowired private VehicleModelService vehicleModelService;
	@Autowired private EmployeeService employeeService;
	@Autowired private LocationService locationService;

	@GetMapping("/vehicle")
	public String getVehicle(Model model) {
		model.addAttribute("vehicles", vehicleService.getVehicles());
		model.addAttribute("vehicleTypes", vehicleTypeService.getVehicleType());
		model.addAttribute("vehicleMakes", vehicleMakeService.getVehicleMake());
		model.addAttribute("vehicleStatuses", vehicleStatusService.getVehicleStatus());
		model.addAttribute("vehicleModels", vehicleModelService.getVehicleModel());
		model.addAttribute("employees", employeeService.getEmployees());
		model.addAttribute("locations", locationService.getLocation());
		return "vehicle";
	}
	
	@PostMapping("/vehicle/addNew")
	public String saveVehicle(Vehicle vehicle) {
		vehicleService.saveVehicle(vehicle);
		return "redirect:/vehicle";
	}
	
	@RequestMapping("/vehicle/findById")
	@ResponseBody
	public Optional<Vehicle> findVehicleById(int id) {
		return vehicleService.getVehicleById(id);
	}
	
	@RequestMapping(value = "/vehicle/update", method = {RequestMethod.GET, RequestMethod.PUT})
	public String updateVehicle(Vehicle vehicle) {
		vehicleService.saveVehicle(vehicle);
		return "redirect:/vehicle";
	}
	
	@RequestMapping(value = "vehicle/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String deleteVehicle(Integer id) {
		vehicleService.deleteVehicle(id);
		return "redirect:/vehicle";
	}
}
