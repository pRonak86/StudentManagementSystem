package com.example.demo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Lecture;

@Repository
public interface LectureRepository extends JpaRepository<Lecture, Long> {

}
