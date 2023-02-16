package com.sheriff.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sheriff.fleetapp.models.VehicleHire;
import com.sheriff.fleetapp.repositories.VehicleHireRepository;

@Service
public class VehicleHireService {
	
	@Autowired
	private VehicleHireRepository vehicleHireRepository;
	
	public List<VehicleHire> getVehicleHires(){
		return vehicleHireRepository.findAll();
	}
	
	public void saveVehicleHire(VehicleHire vehicleHire) {
		vehicleHireRepository.save(vehicleHire);
	}
	
	public Optional<VehicleHire> getVehicleHireById(Integer id) {
		return vehicleHireRepository.findById(id);
	}
	
	public void deleteVehicleHire(Integer id) {
		vehicleHireRepository.deleteById(id);
	}

}
