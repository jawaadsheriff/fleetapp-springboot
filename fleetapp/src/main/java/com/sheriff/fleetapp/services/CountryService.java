package com.sheriff.fleetapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sheriff.fleetapp.models.Country;
import com.sheriff.fleetapp.repositories.CountryRepository;

@Service
public class CountryService {
	
	@Autowired
	private CountryRepository countryRepository;

	public List<Country> getCountries(){
		return countryRepository.findAll();
	}
	
	public void saveCountry(Country country) {
		countryRepository.save(country);
	}
}
