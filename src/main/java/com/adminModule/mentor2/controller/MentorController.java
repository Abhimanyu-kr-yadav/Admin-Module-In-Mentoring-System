package com.adminModule.mentor2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.adminModule.mentor2.model.Mentor;
import com.adminModule.mentor2.service.MentorService;

@Controller
public class MentorController {
	
	
	@Autowired
	private MentorService mentorService;
	//display list of mentors
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listMentors", mentorService.getAllMentors());
		return "index";
	}
	
	@GetMapping("/showNewMentorForm")
	public String showNewMentorForm(Model model) {
		//create model attribute to bind form data
		Mentor mentor = new Mentor();
		model.addAttribute("mentor", mentor);
		return "new_mentor";	
	}
	
	@PostMapping("/saveMentor")
	public String saveMentor(@ModelAttribute("mentor")Mentor mentor) {
		mentorService.saveMentor(mentor);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
		//get mentor from the service
		Mentor mentor = mentorService.getMentorById(id);
		
		//set employee as a model attribute to pre-populate the form
		model.addAttribute("mentor", mentor);
		return "update_mentor";
	}
	
	@GetMapping("/deleteMentor/{id}")
	public String deleteMentor(@PathVariable (value = "id") long id) {
		//call delete employee method
		this.mentorService.deleteMentorById(id);
		return "redirect:/";
		
	}
}
