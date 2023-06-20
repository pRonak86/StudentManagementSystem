package com.example.demo.model.services;

import java.util.List;


import com.example.demo.model.Subject;


public interface SubjectService {
	
	Subject createSubject(Subject subject);
	
	Subject updaSubject (Subject subject);
	
	List<Subject> getAllSubjects();

	void assignSubject(Long userid, Long subjectId);

}
