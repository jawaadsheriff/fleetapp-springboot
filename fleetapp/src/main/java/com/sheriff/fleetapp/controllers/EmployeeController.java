package com.sheriff.fleetapp.controllers;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sheriff.fleetapp.models.Employee;
import com.sheriff.fleetapp.models.FileUploadUtil;
import com.sheriff.fleetapp.services.CountryService;
import com.sheriff.fleetapp.services.EmployeeService;
import com.sheriff.fleetapp.services.EmployeeTypeService;
import com.sheriff.fleetapp.services.JobTitleService;
import com.sheriff.fleetapp.services.StateService;

@Controller
public class EmployeeController {

	@Autowired private EmployeeService employeeService;
	@Autowired private CountryService countryService;
	@Autowired private StateService stateService;
	@Autowired private EmployeeTypeService employeeTypeService;
	@Autowired private JobTitleService jobTitleService;

	@GetMapping("/employee")
	public String getEmployee(Model model) {
		model.addAttribute("employees", employeeService.getEmployees());
		model.addAttribute("countries", countryService.getCountries());
		model.addAttribute("states", stateService.getStates());
		model.addAttribute("employeeTypes", employeeTypeService.getEmployeeTypes());
		model.addAttribute("jobTitles", jobTitleService.getJobTitle());
		return "employee";
	}

	@PostMapping("/employee/addNew")
	public String addEmployee(Employee employee, @RequestParam("image") MultipartFile multipartFile) throws IOException {
		if(!multipartFile.isEmpty()) {
			String filename = employee.getFirstname().toLowerCase() + ".jpeg";
			employee.setPhoto(filename);
			String uploadDir = "src/main/resources/static/assets/img/employees/" + employee.getId();
			FileUploadUtil.saveFile(uploadDir, filename, multipartFile);
		}
		employeeService.saveEmployee(employee);
		return "redirect:/employee";
	}

	@RequestMapping("/employee/findById")
	@ResponseBody
	public Optional<Employee> getEmployeeById(int id) {
		return employeeService.getEmployeeById(id);
	}

	@RequestMapping(value = "/employee/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String updateEmployee(Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/employee";
	}

	@RequestMapping(value = "/employee/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String deleteEmployee(Integer id) {
		employeeService.deleteEmployee(id);
		return "redirect:/employee";
	}
}
