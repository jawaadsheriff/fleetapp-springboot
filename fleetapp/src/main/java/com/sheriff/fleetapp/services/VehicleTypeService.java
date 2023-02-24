package com.sheriff.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sheriff.fleetapp.models.VehicleType;
import com.sheriff.fleetapp.repositories.VehicleTypeRepository;

@Service
public class VehicleTypeService {

	@Autowired
	private VehicleTypeRepository vehicleTypeRepository;

	public List<VehicleType> getVehicleType(){
		return vehicleTypeRepository.findAll();
	}

	public void saveVehicleType(VehicleType vehicleType) {
		vehicleTypeRepository.save(vehicleType);
	}

	public Optional<VehicleType> getVehicleTypeById(Integer id){
		return vehicleTypeRepository.findById(id);
	}

	public void deleteVehicleType(Integer id) {
		vehicleTypeRepository.deleteById(id);
	}
}
