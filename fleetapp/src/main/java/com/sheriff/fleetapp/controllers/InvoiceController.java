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

import com.sheriff.fleetapp.models.Invoice;
import com.sheriff.fleetapp.services.ClientService;
import com.sheriff.fleetapp.services.InvoiceService;
import com.sheriff.fleetapp.services.InvoiceStatusService;

@Controller
public class InvoiceController {
	
	@Autowired
	private InvoiceService invoiceService;
	
	@Autowired
	private InvoiceStatusService invoiceStatusService;
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping("/invoice")
	public String getInvoice(Model model) {
		model.addAttribute("invoices", invoiceService.getInvoices());
		model.addAttribute("invoiceStatuses", invoiceStatusService.getInvoiceStatus());
		model.addAttribute("clients", clientService.getClient());
		return "invoice";
	}
	
	@PostMapping("/invoice/addNew")
	public String saveInvoice(Invoice invoice) {
		invoiceService.saveInvoice(invoice);
		return "redirect:/invoice";
	}
	
	@RequestMapping("/invoice/findById")
	@ResponseBody
	public Optional<Invoice> getInvoiceById(int id) {
		return invoiceService.getInvoiceById(id);
	}

	@RequestMapping(value = "/invoice/update", method = {RequestMethod.GET, RequestMethod.PUT})
	public String updateInvoice(Invoice invoice) {
		invoiceService.saveInvoice(invoice);
		return "redirect:/invoice";
	}
	
	@RequestMapping(value = "/invoice/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String deleteInvoice(Integer id) {
		invoiceService.deleteInvoice(id);
		return "redirect:/invoice";
	}
}
