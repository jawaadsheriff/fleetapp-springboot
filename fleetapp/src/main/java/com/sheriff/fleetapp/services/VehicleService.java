package com.sheriff.fleetapp.services;

import java.util.List;

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
}
