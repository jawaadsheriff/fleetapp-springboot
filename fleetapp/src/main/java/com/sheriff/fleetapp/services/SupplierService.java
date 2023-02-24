package com.sheriff.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sheriff.fleetapp.models.Supplier;
import com.sheriff.fleetapp.repositories.SupplierRepository;

@Service
public class SupplierService {

	@Autowired
	private SupplierRepository supplierRepository;

	public List<Supplier> getSupplier(){
		return supplierRepository.findAll();
	}

	public void saveSupplier(Supplier supplier) {
		supplierRepository.save(supplier);
	}

	public void deleteSupplier(Integer id) {
		supplierRepository.deleteById(id);
	}

	public Optional<Supplier> findSupplierById(Integer id) {
		return supplierRepository.findById(id);
	}
}
