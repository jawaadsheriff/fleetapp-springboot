package com.sheriff.fleetapp.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sheriff.fleetapp.models.Supplier;
import com.sheriff.fleetapp.services.CountryService;
import com.sheriff.fleetapp.services.StateService;
import com.sheriff.fleetapp.services.SupplierService;

@Controller
public class SupplierController {

	@Autowired
	private SupplierService supplierService;

	@Autowired
	private CountryService countryService;

	@Autowired
	private StateService stateService;

	@GetMapping("/supplier")
	public String getSupplier(Model model) {
		model.addAttribute("suppliers", supplierService.getSupplier());
		model.addAttribute("countries", countryService.getCountries());
		model.addAttribute("states", stateService.getStates());
		return "supplier";
	}

	@PostMapping("/supplier/addNew")
	public String saveSupplier(Supplier supplier) {
		supplierService.saveSupplier(supplier);
		return "redirect:/supplier";
	}

	@RequestMapping("/supplier/findById")
	@ResponseBody
	public Optional<Supplier> findSupplierById(int id) {
		return supplierService.findSupplierById(id);
	}

	@RequestMapping(value = "/supplier/update", method = {RequestMethod.GET, RequestMethod.PUT})
	public String updateSupplier(Supplier supplier) {
		supplierService.saveSupplier(supplier);
		return "redirect:/supplier";
	}

	@RequestMapping(value = "/supplier/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String deleteSupplier(Integer id) {
		supplierService.deleteSupplier(id);
		return "redirect:/supplier";
	}
}
