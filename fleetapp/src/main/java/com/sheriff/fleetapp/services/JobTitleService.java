package com.sheriff.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sheriff.fleetapp.models.JobTitle;
import com.sheriff.fleetapp.repositories.JobTitleRepository;

@Service
public class JobTitleService {

	@Autowired
	private JobTitleRepository jobTitleRepository;
	
	public List<JobTitle> getJobTitle(){
		return jobTitleRepository.findAll();
	}
	
	public void saveJobTitle(JobTitle jobTitle) {
		jobTitleRepository.save(jobTitle);
	}
	
	public Optional<JobTitle> getJobTitleById(Integer id) {
		return jobTitleRepository.findById(id);
	}
	
	public void deleteJobTitle(Integer id) {
		jobTitleRepository.deleteById(id);
	}
}
