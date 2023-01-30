package com.sheriff.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sheriff.fleetapp.models.State;
import com.sheriff.fleetapp.repositories.StateRepository;

@Service
public class StateService {

	@Autowired
	private StateRepository stateRepository;
	
	public List<State> getStates(){
		return stateRepository.findAll();
	}
	
	public Optional<State> getStateById(Integer id) {
		return stateRepository.findById(id);
	}
	
	public void saveState(State state) {
		stateRepository.save(state);
	}
	
	public void deleteState(Integer id) {
		stateRepository.deleteById(id);
	}
}
