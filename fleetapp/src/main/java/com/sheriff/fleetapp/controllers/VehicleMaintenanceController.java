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

import com.sheriff.fleetapp.models.VehicleMaintenance;
import com.sheriff.fleetapp.services.SupplierService;
import com.sheriff.fleetapp.services.VehicleMaintenanceService;
import com.sheriff.fleetapp.services.VehicleService;

@Controller
public class VehicleMaintenanceController {
	
	@Autowired
	private VehicleMaintenanceService vehicleMaintenanceService;
	
	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private SupplierService supplierService;

	@GetMapping("/vehicleMaintenance")
	public String getVehicleMaintenance(Model model) {
		model.addAttribute("vehicleMaintenances", vehicleMaintenanceService.getVehicleMaintenance());
		model.addAttribute("vehicles", vehicleService.getVehicles());
		model.addAttribute("suppliers", supplierService.getSupplier());
		return "vehicleMaintenance";
	}
	
	@PostMapping("/vehicleMaintenance/addNew")
	public String saveVehicleMaintenance(VehicleMaintenance vehicleMaintenance) {
		vehicleMaintenanceService.saveVehicleMaintenance(vehicleMaintenance);
		return "redirect:/vehicleMaintenance";
	}
	
	@RequestMapping("/vehicleMaintenance/findById")
	@ResponseBody
	public Optional<VehicleMaintenance> findVehicleMaintenanceById(int id) {
		return vehicleMaintenanceService.getVehicleMaintenanceById(id);
	}
	
	@RequestMapping(value = "/vehicleMaintenance/update", method = {RequestMethod.GET, RequestMethod.PUT})
	public String updateVehicleMaintenance(VehicleMaintenance vehicleMaintenance) {
		vehicleMaintenanceService.saveVehicleMaintenance(vehicleMaintenance);
		return "redirect:/vehicleMaintenance";
	}
	
	@RequestMapping(value = "/vehicleMaintenance/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String deleteVehicleMaintenance(Integer id) {
		vehicleMaintenanceService.deleteVehicleMaintenance(id);
		return "redirect:/vehicleMaintenance";
	}
}
