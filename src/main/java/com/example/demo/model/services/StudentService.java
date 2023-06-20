package com.example.demo.model.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.model.Subject;

@Service
public interface StudentService {

	Student createStudent(Student student);
	
	Student updaStudent (Student student);
	
	List<Student> getAllStudent();

	List<Subject> getAssignedSubjects(int semester);
}
