package com.example.demo.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserSubject;

@Repository
public interface UserSubjectRepository extends JpaRepository<UserSubject, Long> {

	List<UserSubject> findByUserId(Long userId);

}
