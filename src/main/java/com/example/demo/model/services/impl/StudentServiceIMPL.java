package com.example.demo.model.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.model.Subject;
import com.example.demo.model.repository.StudentRepository;
import com.example.demo.model.repository.SubjectRepository;
import com.example.demo.model.services.StudentService;

@Service
public class StudentServiceIMPL  implements StudentService{

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private SubjectRepository subjectRepository;
		
	@Override
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student updaStudent(Student student) {
	
		Student exStudent = studentRepository.findById((long)student.getId()).get();
		exStudent.setName(student.getName());
		exStudent.setContact(student.getContact());
		exStudent.setSemester(student.getSemester());
		
		Student updateStudent = studentRepository.save(exStudent);
		return updateStudent;
		
	}

	@Override
	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}

	@Override
	public List<Subject> getAssignedSubjects(int semester) {
		
		return  subjectRepository.findBySemester(semester);

	}
	

}
