package com.sheriff.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sheriff.fleetapp.models.Employee;
import com.sheriff.fleetapp.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired private EmployeeRepository employeeRepository;

	public List<Employee> getEmployees(){
		return employeeRepository.findAll();
	}
	
	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);
	}
	
	public Optional<Employee> getEmployeeById(Integer id) {
		return employeeRepository.findById(id);
	}
	
	public void deleteEmployee(Integer id) {
		employeeRepository.deleteById(id);
	}
}
