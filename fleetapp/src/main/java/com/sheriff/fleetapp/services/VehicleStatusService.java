package com.sheriff.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sheriff.fleetapp.models.VehicleStatus;
import com.sheriff.fleetapp.repositories.VehicleStatusRepository;

@Service
public class VehicleStatusService {

	@Autowired
	private VehicleStatusRepository vehicleStatusRepository;

	public List<VehicleStatus> getVehicleStatus(){
		return vehicleStatusRepository.findAll();
	}

	public void saveVehicleStatus(VehicleStatus vehicleStatus) {
		vehicleStatusRepository.save(vehicleStatus);
	}

	public Optional<VehicleStatus> getVehicleStatusById(Integer id) {
		return vehicleStatusRepository.findById(id);
	}

	public void deleteVehicleStatus(Integer id) {
		vehicleStatusRepository.deleteById(id);
	}
}
