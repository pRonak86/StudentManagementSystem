package com.example.demo.model.services;


import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Faculty;
import com.example.demo.model.Subject;

@Service
public interface FacultyService {
	
	
	Faculty updaFaculty (Faculty faculty);

	Faculty createFaculty(Faculty faculty);
	
	List<Faculty> getAllFaculty();

	List<Subject> fetchAssignedSubjects(Long userId);
}
