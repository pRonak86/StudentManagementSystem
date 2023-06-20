package com.example.demo.model.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Subject;
import com.example.demo.model.UserSubject;
import com.example.demo.model.repository.SubjectRepository;
import com.example.demo.model.repository.UserSubjectRepository;
import com.example.demo.model.services.SubjectService;

@Service
public class SubjectServiceIMPL implements SubjectService {
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	@Autowired
	private UserSubjectRepository userSubjectRepository;
	

	@Override
	public Subject createSubject(Subject subject) {
		return subjectRepository.save(subject);
	}

	@Override
	public Subject updaSubject(Subject subject) {
		
		Subject existingSubject = subjectRepository.findById((long) subject.getId()).get();
		existingSubject.setSubjectName(subject.getSubjectName());
		existingSubject.setCode(subject.getCode());
		existingSubject.setSemester(subject.getSemester());
		
		Subject updateSubject = subjectRepository.save(existingSubject);
		return updateSubject;
	}

	@Override
	public List<Subject> getAllSubjects() {
		return subjectRepository.findAll();
	}

	@Override
	public void assignSubject(Long userid, Long subjectId) {
		
		UserSubject userSubject = new UserSubject();
		userSubject.setUserId(userid);
		userSubject.setSubjectId(subjectId);
		
		userSubjectRepository.save(userSubject);
	}
	
	

}
