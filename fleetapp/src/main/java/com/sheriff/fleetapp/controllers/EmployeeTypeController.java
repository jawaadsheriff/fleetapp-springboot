package com.sheriff.fleetapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sheriff.fleetapp.models.EmployeeType;
import com.sheriff.fleetapp.services.EmployeeTypeService;

@Controller
public class EmployeeTypeController {

	@Autowired
	private EmployeeTypeService employeeTypeService;

	@GetMapping("/employeeType")
	public String getEmployeeType(Model model) {
		List<EmployeeType> employeeTypeList = employeeTypeService.getEmployeeTypes();
		model.addAttribute("employeeTypes", employeeTypeList);
		return "employeeType";
	}
	
	@PostMapping("/employeeType/addNew")
	public String saveEmployeeType(EmployeeType employeeType) {
		employeeTypeService.saveEmployeeType(employeeType);
		return "redirect:/employeeType";
	}
	
	@RequestMapping("/employeeType/findById")
	@ResponseBody
	public Optional<EmployeeType> getEmployeeTypeById(int id) {
		return employeeTypeService.getEmployeeTypeById(id);
	}
	
	@RequestMapping(value = "/employeeType/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String updateEmployeeType(EmployeeType employeeType) {
		employeeTypeService.saveEmployeeType(employeeType);
		return "redirect:/employeeType";
	}
	
	@RequestMapping(value = "/employeeType/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String deleteEmployeeType(Integer id) {
		employeeTypeService.deleteEmployeeType(id);
		return "redirect:/employeeType";
	}
}
