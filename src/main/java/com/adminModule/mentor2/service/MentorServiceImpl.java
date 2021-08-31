package com.adminModule.mentor2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminModule.mentor2.model.Mentor;
import com.adminModule.mentor2.repository.MentorRepository;

@Service
public class MentorServiceImpl implements MentorService{

	@Autowired
	private MentorRepository mentorRepository;
	
	@Override
	public List<Mentor> getAllMentors() {
		return mentorRepository.findAll();
	}

	@Override
	public void saveMentor(Mentor mentor) {
		this.mentorRepository.save(mentor);
		
	}

	@Override
	public Mentor getMentorById(long id) {
		java.util.Optional<Mentor> optional = mentorRepository.findById(id);
		Mentor mentor = null;
		if(optional.isPresent()) {
			mentor = optional.get();	
		}else {
			throw new RuntimeException("Employee not found for id :: " + id);
		}
		return mentor;
	}

	@Override
	public void deleteMentorById(long id) {
		this.mentorRepository.deleteById(id);
		
	}

}
