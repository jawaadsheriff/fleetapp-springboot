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

import com.sheriff.fleetapp.models.JobTitle;
import com.sheriff.fleetapp.services.JobTitleService;

@Controller
public class JobTitleController {

	@Autowired
	private JobTitleService jobTitleService;

	@GetMapping("/jobTitle")
	public String getJobTitle(Model model) {
		List<JobTitle> jobTitleList = jobTitleService.getJobTitle();
		model.addAttribute("jobTitles", jobTitleList);
		return "jobTitle";
	}
	
	@PostMapping("/jobTitle/addNew")
	public String saveJobTitle(JobTitle jobTitle) {
		jobTitleService.saveJobTitle(jobTitle);
		return "redirect:/jobTitle";
	}
	
	@RequestMapping("/jobTitle/findById")
	@ResponseBody
	public Optional<JobTitle> getJobTitleById(int id) {
		return jobTitleService.getJobTitleById(id);
	}
	
	@RequestMapping(value = "/jobTitle/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String updateJobTitle(JobTitle jobTitle) {
		jobTitleService.saveJobTitle(jobTitle);
		return "redirect:/jobTitle";
	}
	
	@RequestMapping(value = "/jobTitle/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String deleteJobTitle(Integer id) {
		jobTitleService.deleteJobTitle(id);
		return "redirect:/jobTitle";
	}
}
