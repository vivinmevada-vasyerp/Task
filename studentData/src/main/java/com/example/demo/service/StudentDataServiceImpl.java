package com.example.demo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.model.BookData;
import com.example.demo.model.StudentData;
import com.example.demo.repository.BookDataRepository;
import com.example.demo.repository.StudentDataRepository;

@Service
public class StudentDataServiceImpl implements StudentDataService {

	@Autowired
	StudentDataRepository studentDataRepository;
	@Autowired
	BookDataRepository bookDataRepository;

	@Override
	public List<StudentData> getAllStudents() {
		// TODO Auto-generated method stub
		return studentDataRepository.findAll();
	}

	@Override
	public StudentData saveStudent(StudentData student) {

			return studentDataRepository.save(student);
		
	}

	@Override
	public void deleteStudent(long studentId) { // TODO Auto-generated method
			
		studentDataRepository.findById(studentId).orElseThrow(() -> new StudentNotFoundException("Student not found"));
		
		studentDataRepository.deleteById(studentId);
	}

	@Override
	public StudentData editStudent(StudentData studentData) {
		// TODO Auto-generated method stub
		StudentData editData = studentDataRepository.findById(studentData.getStudentId()).orElse(null);

		if (editData != null) {
			editData.setStudentName(studentData.getStudentName());
			editData.setStudentDivision(studentData.getStudentDivision());
			editData.setStudentRollNumber(studentData.getStudentRollNumber());
			editData.setStudentStandard(studentData.getStudentStandard());
			studentDataRepository.save(editData);
			return editData;
		}
		return null;
	}

	@Override
	public StudentData addBook(long studentId, long bookId) {

		StudentData s = studentDataRepository.findById(studentId).get();

		// BookData bookData = bookDataRepository.findById(bookId).get();
		/*
		 * BookData l = new BookData(); l.setBookId(bookData.getBookId());
		 * l.setBookName(bookData.getBookName()); l.setBookDesc(bookData.getBookDesc());
		 */

		BookData bookData = new BookData();
		bookData.setBookId(bookId);

		s.setBookData(bookData);

		return studentDataRepository.save(s);
	}

}
