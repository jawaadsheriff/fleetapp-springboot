package com.sheriff.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sheriff.fleetapp.models.VehicleMaintenance;
import com.sheriff.fleetapp.repositories.VehicleMaintenanceRepository;

@Service
public class VehicleMaintenanceService {

	@Autowired
	private VehicleMaintenanceRepository vehicleMaintenanceRepository;
	
	public List<VehicleMaintenance> getVehicleMaintenance(){
		return vehicleMaintenanceRepository.findAll();
	}
	
	public void saveVehicleMaintenance(VehicleMaintenance vehicleMaintenance) {
		vehicleMaintenanceRepository.save(vehicleMaintenance);
	}
	
	public void deleteVehicleMaintenance(Integer id) {
		vehicleMaintenanceRepository.deleteById(id);
	}
	
	public Optional<VehicleMaintenance> getVehicleMaintenanceById(Integer id) {
		return vehicleMaintenanceRepository.findById(id);
	}
}
