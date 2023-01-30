package com.sheriff.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sheriff.fleetapp.models.Location;
import com.sheriff.fleetapp.repositories.LocationRepository;

@Service
public class LocationService {

	@Autowired
	private LocationRepository locationRepository;
	
	public List<Location> getLocation(){
		return locationRepository.findAll();
	}
	
	public void saveLocation(Location location) {
		locationRepository.save(location);
	}
	
	public Optional<Location> getLocationById(Integer id) {
		return locationRepository.findById(id);
	}
	
	public void deleteLocationById(Integer id) {
		locationRepository.deleteById(id);
	}
}
