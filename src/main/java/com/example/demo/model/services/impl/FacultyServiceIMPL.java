package com.example.demo.model.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Faculty;
import com.example.demo.model.Subject;
import com.example.demo.model.UserSubject;
import com.example.demo.model.repository.FacultyRepository;
import com.example.demo.model.repository.SubjectRepository;
import com.example.demo.model.repository.UserSubjectRepository;
import com.example.demo.model.services.FacultyService;

@Service
public class FacultyServiceIMPL  implements FacultyService{

	@Autowired
	private FacultyRepository facultyRepository;
	
	@Autowired
	private UserSubjectRepository userSubjectRepository;
	
	@Autowired
	private SubjectRepository subjectRepository;
		
	@Override
	public Faculty createFaculty(Faculty faculty) {
		return facultyRepository.save(faculty);
	}

	@Override
	public Faculty updaFaculty(Faculty faculty) {
		
		Faculty existingFaculty = facultyRepository.findById((long) faculty.getId()).get();
		existingFaculty.setName(faculty.getName());
		existingFaculty.setContact(faculty.getContact());
		existingFaculty.setEmail(faculty.getEmail());
		existingFaculty.setRole(faculty.getRole());
		
		Faculty updateFaculty = facultyRepository.save(existingFaculty);
			
		return updateFaculty;
	}

	@Override
	public List<Faculty> getAllFaculty() {
		
		return facultyRepository.findAll();
	}

	@Override
	public List<Subject> fetchAssignedSubjects(Long userId) {
		
		List<UserSubject> userSubjects = userSubjectRepository.findByUserId(userId); 
	 	List<Long> subjectIds =  userSubjects.stream().map(subject -> subject.getSubjectId()).collect(Collectors.toList());
	 	
	 	return subjectRepository.findSubjects(subjectIds);
	 	
	}
	

}
