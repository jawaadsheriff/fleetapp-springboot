package com.sheriff.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sheriff.fleetapp.models.Client;
import com.sheriff.fleetapp.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	public List<Client> getClient(){
		return clientRepository.findAll();
	}
	
	public void saveClient(Client client) {
		clientRepository.save(client);
	}
	
	public void deleteClient(Integer id) {
		clientRepository.deleteById(id);
	}
	
	public Optional<Client> findClientById(Integer id) {
		return clientRepository.findById(id);
	}
}
