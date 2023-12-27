package com.example.demo.service;

import java.util.List;

import com.example.demo.model.StudentData;

public interface StudentDataService {

	List<StudentData> getAllStudents();
	
	  StudentData saveStudent(StudentData student); 
	  
	  void deleteStudent(long studentId);
	  
	  StudentData editStudent(StudentData studentData);
	  
	  StudentData addBook(long studentId, long bookId);
	 
}
