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

import com.sheriff.fleetapp.models.InvoiceStatus;
import com.sheriff.fleetapp.services.InvoiceStatusService;

@Controller
public class InvoiceStatusController {

	@Autowired
	private InvoiceStatusService invoiceStatusService;

	@GetMapping("/invoiceStatus")
	public String getInvoiceStatus(Model model) {
		List<InvoiceStatus> invoiceStatusList = invoiceStatusService.getInvoiceStatus();
		model.addAttribute("invoiceStatuses", invoiceStatusList);
		return "invoiceStatus";
	}

	@PostMapping("/invoiceStatus/addNew")
	public String saveInvoiceStatus(InvoiceStatus invoiceStatus) {
		invoiceStatusService.saveInvoiceStatus(invoiceStatus);
		return "redirect:/invoiceStatus";
	}

	@RequestMapping("/invoiceStatus/findById")
	@ResponseBody
	public Optional<InvoiceStatus> getInvoiceStatusById(int id) {
		return invoiceStatusService.getInvoiceStatusById(id);
	}

	@RequestMapping(value = "/invoiceStatus/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String updateInvoiceStatus(InvoiceStatus invoiceStatus) {
		invoiceStatusService.saveInvoiceStatus(invoiceStatus);
		return "redirect:/invoiceStatus";
	}

	@RequestMapping(value = "/invoiceStatus/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String deleteInvoiceStatus(Integer id) {
		invoiceStatusService.deleteInvoiceStatus(id);
		return "redirect:/invoiceStatus";
	}
}
