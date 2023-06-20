package com.example.demo.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Attendance;

@Repository
public interface AttendanceRepository  extends JpaRepository<Attendance, Long>{

	List<Attendance> findByStudentId(Long studentId);

}
