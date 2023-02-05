package com.sheriff.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sheriff.fleetapp.models.Invoice;
import com.sheriff.fleetapp.repositories.InvoiceRepository;

@Service
public class InvoiceService {
	
	@Autowired
	private InvoiceRepository invoiceRepository;
	
	public List<Invoice> getInvoices(){
		return invoiceRepository.findAll();
	}
	
	public Optional<Invoice> getInvoiceById(Integer id) {
		return invoiceRepository.findById(id);
	}

	public void saveInvoice(Invoice invoice) {
		invoiceRepository.save(invoice);
	}
	
	public void deleteInvoice(Integer id) {
		invoiceRepository.deleteById(id);
	}
}
