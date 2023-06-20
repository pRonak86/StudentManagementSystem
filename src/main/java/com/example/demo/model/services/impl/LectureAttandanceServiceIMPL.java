package com.example.demo.model.services.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Attendance;
import com.example.demo.model.Lecture;
import com.example.demo.model.repository.AttendanceRepository;
import com.example.demo.model.repository.LectureRepository;
import com.example.demo.model.services.LectureAttandanceService;

@Service
public class LectureAttandanceServiceIMPL implements LectureAttandanceService {

	@Autowired
	LectureRepository lectureRepository;

	@Autowired
	AttendanceRepository attendanceRepository;

	@Override
	public void scheduleLecture(Long userId, Long subjectId, LocalDateTime lectureDate) {

		Lecture lecture = new Lecture();
		lecture.setUserId(userId);
		lecture.setSubjectId(subjectId);
		lecture.setLectureDate(lectureDate);

		lectureRepository.save(lecture);

	}

	public void markAttendance(Attendance attendance) {
		attendanceRepository.save(attendance);
	}

	@Override
	public List<Attendance> viewAttendance(Long studentId) {
		
		return attendanceRepository.findByStudentId(studentId);
	}

}
