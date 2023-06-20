package com.example.demo.model.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Attendance;
import com.example.demo.model.services.LectureAttandanceService;

@RestController
public class LectureAttandanceController {
	
	@Autowired
	LectureAttandanceService lectureAttandanceService;

	@PostMapping("/faculty/schedule-lecture")
	public ResponseEntity<String> scheduleLecture(@RequestParam Long userId,@RequestParam Long subjectId,@RequestParam LocalDateTime lectureDate)
	{
		lectureAttandanceService.scheduleLecture(userId,subjectId,lectureDate);
		return new ResponseEntity<>("Lecture Scheduled Sucessfully", HttpStatus.CREATED);
	}
	
	@PostMapping("/faculty/attendance")
	public ResponseEntity<String> markAttendance(@RequestBody Attendance attendance)
	{
		lectureAttandanceService.markAttendance(attendance);
		return new ResponseEntity<>("Attendance Enter Sucessfully", HttpStatus.CREATED);
	}
	
	@GetMapping("/student/view-attendance")
	public ResponseEntity<List<Attendance>> viewAttendance(@RequestParam Long studentId)
	{
		List<Attendance> attendances =  lectureAttandanceService.viewAttendance(studentId);
		return new ResponseEntity<>(attendances, HttpStatus.CREATED);	
	}
}
