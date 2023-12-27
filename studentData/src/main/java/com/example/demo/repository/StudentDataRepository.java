package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.StudentData;

@Repository
public interface StudentDataRepository extends JpaRepository<StudentData, Long> {

}
