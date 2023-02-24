package com.sheriff.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sheriff.fleetapp.models.InvoiceStatus;
import com.sheriff.fleetapp.repositories.InvoiceStatusRepository;

@Service
public class InvoiceStatusService {

	@Autowired
	private InvoiceStatusRepository invoiceStatusRepository;

	public List<InvoiceStatus> getInvoiceStatus(){
		return invoiceStatusRepository.findAll();
	}

	public void saveInvoiceStatus(InvoiceStatus invoiceStatus) {
		invoiceStatusRepository.save(invoiceStatus);
	}

	public Optional<InvoiceStatus> getInvoiceStatusById(Integer id) {
		return invoiceStatusRepository.findById(id);
	}

	public void deleteInvoiceStatus(Integer id) {
		invoiceStatusRepository.deleteById(id);
	}
}
