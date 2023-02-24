package com.sheriff.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sheriff.fleetapp.models.Vehicle;
import com.sheriff.fleetapp.repositories.VehicleRepository;

@Service
public class VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;

	public List<Vehicle> getVehicles(){
		return vehicleRepository.findAll();
	}

	public void saveVehicle(Vehicle vehicle) {
		vehicleRepository.save(vehicle);
	}

	public Optional<Vehicle> getVehicleById(Integer id) {
		return vehicleRepository.findById(id);
	}

	public void deleteVehicle(Integer id) {
		vehicleRepository.deleteById(id);
	}
}
