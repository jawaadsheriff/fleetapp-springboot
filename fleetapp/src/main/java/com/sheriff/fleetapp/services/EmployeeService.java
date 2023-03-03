package com.sheriff.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sheriff.fleetapp.models.Employee;
import com.sheriff.fleetapp.models.User;
import com.sheriff.fleetapp.repositories.EmployeeRepository;
import com.sheriff.fleetapp.repositories.UserRepository;

@Service
public class EmployeeService {

	@Autowired private EmployeeRepository employeeRepository;
	@Autowired private UserRepository userRepository;

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
	
	public Employee findByUsername(String username) {
		return employeeRepository.findByUsername(username);
	}
	
	public void assignUsername(int id) {
		Employee employee = employeeRepository.findById(id).orElse(null);
		User user = userRepository.findByFirstnameAndLastname(employee.getFirstname(), employee.getLastname());
		employee.setUsername(user.getUsername());
		employeeRepository.save(employee);
	}
}
