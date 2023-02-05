package com.sheriff.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sheriff.fleetapp.models.Contact;
import com.sheriff.fleetapp.repositories.ContactRepository;

@Service
public class ContactService {

	@Autowired
	private ContactRepository contactRepository;
	
	public List<Contact> getContact(){
		return contactRepository.findAll();
	}
	
	public void saveContact(Contact contact) {
		contactRepository.save(contact);
	}
	
	public void deleteContact(Integer id) {
		contactRepository.deleteById(id);
	}
	
	public Optional<Contact> findContactById(Integer id) {
		return contactRepository.findById(id);
	}
}
