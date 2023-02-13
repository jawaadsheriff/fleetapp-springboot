package com.sheriff.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sheriff.fleetapp.models.VehicleMovement;
import com.sheriff.fleetapp.repositories.VehicleMovementRepository;

@Service
public class VehicleMovementService {
	
	@Autowired
	private VehicleMovementRepository vehicleMovementRepository;
	
	public List<VehicleMovement> getVehicleMovement(){
		return vehicleMovementRepository.findAll();
	}
	
	public Optional<VehicleMovement> getVehicleMovementById(Integer id) {
		return vehicleMovementRepository.findById(id);
	}
	
	public void saveVehicleMovement(VehicleMovement vehicleMovement) {
		vehicleMovementRepository.save(vehicleMovement);
	}
	
	public void deleteVehicleMovement(Integer id) {
		vehicleMovementRepository.deleteById(id);
	}
}
