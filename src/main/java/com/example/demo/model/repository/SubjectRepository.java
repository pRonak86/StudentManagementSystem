package com.example.demo.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

	@Query(nativeQuery =true,value = "SELECT * FROM Subject as s WHERE s.id IN (:subjectIds)")
	List<Subject> findSubjects(List<Long> subjectIds);

	List<Subject> findBySemester(int semester);

}
