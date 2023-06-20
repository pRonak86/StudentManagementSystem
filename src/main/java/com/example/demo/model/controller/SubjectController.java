package com.example.demo.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Subject;
import com.example.demo.model.services.SubjectService;

@RestController
@RequestMapping("/sms")
public class SubjectController {

	@Autowired
	SubjectService subjectService;

	@PostMapping("admin/subject/save")
	public ResponseEntity<Subject> createStudent(@RequestBody Subject subject) {
		Subject saveSubject = subjectService.createSubject(subject);
		return new ResponseEntity<>(saveSubject, HttpStatus.CREATED);
	}

	@PutMapping("subject/update/{id}")
	public ResponseEntity<Subject> updateSubject(@PathVariable("id") Long subjectId, @RequestBody Subject subject) {
		subject.setId(subjectId);
		Subject subject2 = subjectService.updaSubject(subject);
		return new ResponseEntity<>(subject2, HttpStatus.OK);
	}

	@GetMapping("admin/subject/all")
	public ResponseEntity<List<Subject>> getAllSubjects() {
		List<Subject> subjects = subjectService.getAllSubjects();
		return new ResponseEntity<>(subjects, HttpStatus.OK);
	}

	
	//assign subject to faculty
	@PostMapping("admin/subject/assign")
	public ResponseEntity<String> assignSubject(@RequestParam Long userid, @RequestParam Long subjectId) {
		subjectService.assignSubject(userid,subjectId);
		return new ResponseEntity<>("Subject Assinged Successfully", HttpStatus.OK);
	}

}
