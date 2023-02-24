package com.sheriff.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sheriff.fleetapp.models.EmployeeType;
import com.sheriff.fleetapp.repositories.EmployeeTypeRepository;

@Service
public class EmployeeTypeService {

	@Autowired
	private EmployeeTypeRepository employeeTypeRepository;

	public List<EmployeeType> getEmployeeTypes(){
		return employeeTypeRepository.findAll();
	}

	public void saveEmployeeType(EmployeeType employeeType) {
		employeeTypeRepository.save(employeeType);
	}

	public Optional<EmployeeType> getEmployeeTypeById(Integer id) {
		return employeeTypeRepository.findById(id);
	}

	public void deleteEmployeeType(Integer id) {
		employeeTypeRepository.deleteById(id);
	}
}
