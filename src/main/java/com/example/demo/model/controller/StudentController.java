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

import com.example.demo.model.Student;
import com.example.demo.model.Subject;
import com.example.demo.model.services.StudentService;

@RestController
@RequestMapping("/sms")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	// insert faculty Data
	@PostMapping("admin/student/save")
	 public ResponseEntity<Student> createStudent(@RequestBody Student student){
		Student saveStudent = studentService.createStudent(student);
		return new ResponseEntity<> (saveStudent,HttpStatus.CREATED);
    }
	
	// Update Faculty Data
	@PutMapping("student/update/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id") Long studentId,@RequestBody Student student )
	{
		student.setId(studentId);
		Student student2= studentService.updaStudent(student);
		return new ResponseEntity<>(student2,HttpStatus.OK);
	}
	
	@GetMapping("admin/student/all")
	public ResponseEntity<List<Student>> getAllStudents()
	{
		List<Student> student = studentService.getAllStudent();
		return new ResponseEntity<> (student,HttpStatus.OK);
	}
	
	@GetMapping("student/assigned-subjects")
	public ResponseEntity<List<Subject>> getAssignedSubjects(@RequestParam int semester)
	{
		List<Subject> subjects =  studentService.getAssignedSubjects(semester);
		return new ResponseEntity<> (subjects,HttpStatus.OK);
	}
}