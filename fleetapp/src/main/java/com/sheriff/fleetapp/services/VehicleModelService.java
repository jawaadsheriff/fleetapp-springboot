package com.sheriff.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sheriff.fleetapp.models.VehicleModel;
import com.sheriff.fleetapp.repositories.VehicleModelRepository;

@Service
public class VehicleModelService {

	@Autowired
	private VehicleModelRepository vehicleModelRepository;

	public List<VehicleModel> getVehicleModel(){
		return vehicleModelRepository.findAll();
	}

	public Optional<VehicleModel> getVehicleModelById(Integer id) {
		return vehicleModelRepository.findById(id);
	}

	public void saveVehicleModel(VehicleModel vehicleModel) {
		vehicleModelRepository.save(vehicleModel);
	}

	public void deleteVehicleModel(Integer id) {
		vehicleModelRepository.deleteById(id);
	}
}
