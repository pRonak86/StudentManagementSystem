package com.example.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "attendance")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attendance_id")
    private Long attendanceId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "lecture_id")
    private Long lectureId;

    @Column(name = "is_present")
    private boolean isPresent;
    
    @Column(name = "lecture_date")
    private LocalDateTime lectureDate;

	public Long getAttendanceId() {
		return attendanceId;
	}

	public void setAttendanceId(Long attendanceId) {
		this.attendanceId = attendanceId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public Long getLectureId() {
		return lectureId;
	}

	public void setLectureId(Long lectureId) {
		this.lectureId = lectureId;
	}

	public boolean isPresent() {
		return isPresent;
	}

	public void setPresent(boolean isPresent) {
		this.isPresent = isPresent;
	}

	public LocalDateTime getLectureDate() {
		return lectureDate;
	}

	public void setLectureDate(LocalDateTime lectureDate) {
		this.lectureDate = lectureDate;
	}

}
