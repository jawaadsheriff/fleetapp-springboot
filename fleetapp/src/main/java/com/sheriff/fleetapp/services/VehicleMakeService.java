package com.sheriff.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sheriff.fleetapp.models.VehicleMake;
import com.sheriff.fleetapp.repositories.VehicleMakeRepository;

@Service
public class VehicleMakeService {

	@Autowired
	private VehicleMakeRepository vehicleMakeRepository;

	public List<VehicleMake> getVehicleMake(){
		return vehicleMakeRepository.findAll();
	}

	public void saveVehicleMake(VehicleMake vehicleMake) {
		vehicleMakeRepository.save(vehicleMake);
	}

	public Optional<VehicleMake> getVehicleMakeById(Integer id) {
		return vehicleMakeRepository.findById(id);
	}

	public void deleteVehicleMakeById(Integer id) {
		vehicleMakeRepository.deleteById(id);
	}
}
