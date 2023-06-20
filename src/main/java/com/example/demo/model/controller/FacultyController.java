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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Faculty;
import com.example.demo.model.Subject;
import com.example.demo.model.services.FacultyService;

@RestController
@RequestMapping("/sms")
public class FacultyController {
	
	@Autowired
	private FacultyService facService;
	
	// insert faculty Data
	@PostMapping("admin/faculty/save")
	 public ResponseEntity<Faculty> createUser(@RequestBody Faculty faculty){
        Faculty savedUser = facService.createFaculty(faculty);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
	
	// Update Faculty Data
	@PutMapping("faculty/update/{id}")
	public ResponseEntity<Faculty> updateFaculty(@PathVariable("id") Long facultyId,@RequestBody Faculty faculty )
	{
		faculty.setId(facultyId);
		Faculty faculty2 = facService.createFaculty(faculty);
		return new ResponseEntity<>(faculty2,HttpStatus.OK);
	}

	@GetMapping("admin/faculty/all")
	public ResponseEntity<List<Faculty>> getAllFacultyDetails()
	{
		List<Faculty> faculty = facService.getAllFaculty();
		return new ResponseEntity<>(faculty,HttpStatus.OK);
	}
	
	@GetMapping("faculty/assigned-subjects/{userId}")
	public ResponseEntity<List<Subject>> assignedSubject(@PathVariable("userId") Long userId)
	{
		List<Subject> subject = facService.fetchAssignedSubjects(userId);
		return new ResponseEntity<>(subject,HttpStatus.OK);
		
	}
	
}
