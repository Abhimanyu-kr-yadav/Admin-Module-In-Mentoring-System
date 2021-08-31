package com.adminModule.mentor2.service;

import java.util.List;

import com.adminModule.mentor2.model.Mentor;

public interface MentorService {
	List<Mentor> getAllMentors();
	void saveMentor(Mentor mentor); 
	Mentor getMentorById(long id);
	void deleteMentorById(long id);
	
	
}
