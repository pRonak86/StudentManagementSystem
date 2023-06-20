package com.example.demo.model.services;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.model.Attendance;

public interface LectureAttandanceService {

	void scheduleLecture(Long userId, Long subjectId, LocalDateTime lectureDate);


	void markAttendance(Attendance attendance);


	List<Attendance> viewAttendance(Long studentId);

}
