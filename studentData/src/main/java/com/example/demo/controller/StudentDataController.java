package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
/*import org.springframework.http.ResponseEntity;*/
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
/*import org.springframework.web.bind.annotation.DeleteMapping;*/
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
/*import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;*/
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/*import org.springframework.web.bind.annotation.RequestParam;*/
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.ResponseDTO;
/*import com.example.demo.dto.StudentDataDTO;*/
import com.example.demo.model.StudentData;
import com.example.demo.repository.BookDataRepository;
import com.example.demo.repository.StudentDataRepository;
import com.example.demo.service.StudentDataService;

@Controller
@RequestMapping("/student")
public class StudentDataController {

	@Autowired
	StudentDataService studentDataService;

	ResponseDTO responseDTO = new ResponseDTO();

	@Autowired
	StudentDataRepository studentDataRepository;

	@Autowired
	BookDataRepository bookDataRepository;

	int code = 0;

	// ============================= fetching Student Data========================
	@GetMapping("/get")
	@ResponseBody
	public ResponseEntity<Object> getAllStudents() {
		// String string = studentDataService.getAllStudents().toString();

		responseDTO.setData(studentDataService.getAllStudents());
		responseDTO.setMessage("OK");
		responseDTO.setStatus(200);

		// return new ResponseEntity<>(responseDTO,HttpStatusCode.valueOf(200));
		return new ResponseEntity<>(responseDTO, HttpStatusCode.valueOf(200));
	}

	// ============================= posting Student Data========================
	@PostMapping("/post")
	@ResponseBody
	public ResponseEntity<Object> saveStudent(@RequestBody StudentData student) {
		// return studentDataService.saveStudent(student);

		if (student.getStudentStandard() == 0) {
			responseDTO.setData("Please enter the value of Student's Standard");
			responseDTO.setMessage("EMPTY FIELD");
			code = 400;
			responseDTO.setStatus(code);
		} else if (student.getStudentDivision() == null) {
			responseDTO.setData("Please enter the value of Student's Division");
			responseDTO.setMessage("EMPTY FIELD");
			code = 400;
			responseDTO.setStatus(code);
		} else if (student.getStudentRollNumber() == 0) {
			responseDTO.setData("Please enter the value of Student's ROll Number");
			responseDTO.setMessage("EMPTY FIELD");
			code = 400;
			responseDTO.setStatus(code);
		} else if (student.getStudentName() == null) {
			responseDTO.setData("Please enter the value of Student's Name");
			responseDTO.setMessage("EMPTY FIELD");
			code = 400;
			responseDTO.setStatus(code);
		} else {
			responseDTO.setData(studentDataService.saveStudent(student));
			responseDTO.setMessage("CREATED");
			code = 201;
			responseDTO.setStatus(code);
		}
		return new ResponseEntity<>(responseDTO, HttpStatusCode.valueOf(code));
		// return new
		// ResponseEntity<>(studentDataService.saveStudent(student),HttpStatusCode.valueOf(201));
		// return new ResponseEntity<> (studentDataService.ge)
	}

	// ============================= deleting Student Data========================
	@DeleteMapping("/delete")
	@ResponseBody
	public ResponseEntity<Object> deleteSudent(@RequestParam("studentId") long studentId) {

		// List<Long> list = new ArrayList<>();
		/*
		 * for(StudentData studentData: studentDataRepository.findAll()) {
		 * list.add(studentData.getStudentId()); }
		 * 
		 */

		if (studentDataRepository.existsById(studentId)) {
			studentDataRepository.deleteById(studentId);
			code = 200;
			responseDTO.setMessage("OK");
			responseDTO.setStatus(code);
			responseDTO.setData("Student Id: " + studentId + " is sucessfully DELETD");
		} else {
			code = 404;
			responseDTO.setMessage("Data Not Found");
			responseDTO.setStatus(code);
			responseDTO.setData("Student Id didn't exist");
		}

		// studentDataService.deleteStudent(studentId);
		/*
		 * responseDto.setData("Student ID: " + studentId + " is Deleted");
		 * responseDto.setMessage("OK"); responseDto.setStatus(200);
		 */
		return new ResponseEntity<>(responseDTO, HttpStatusCode.valueOf(200));
		// return new ResponseEntity<>(studentDataService.deleteStudent(studentId),
		// HttpStatusCode.valueOf(200));
	}

	// ============================= editing Student Data========================
	@PutMapping("/edit")
	@ResponseBody
	public ResponseEntity<Object> edit(@RequestBody StudentData student) {
		// studentDataService.editStudent(studentData);

		/*
		 * responseDTO.setData("Data Edited Successfully");
		 * responseDTO.setMessage("OK"); responseDTO.setStatus(200);
		 */

		if (studentDataRepository.existsById(student.getStudentId())) {
			if (student.getStudentStandard() == 0) {
				responseDTO.setData("Please enter the value of Student's Standard");
				responseDTO.setMessage("EMPTY FIELD");
				code = 400;
				responseDTO.setStatus(code);
			} else if (student.getStudentDivision() == null) {
				responseDTO.setData("Please enter the value of Student's Division");
				responseDTO.setMessage("EMPTY FIELD");
				code = 400;
				responseDTO.setStatus(code);
			} else if (student.getStudentRollNumber() == 0) {
				responseDTO.setData("Please enter the value of Student's ROll Number");
				responseDTO.setMessage("EMPTY FIELD");
				code = 400;
				responseDTO.setStatus(code);
			} else if (student.getStudentName() == null) {
				responseDTO.setData("Please enter the value of Student's Name");
				responseDTO.setMessage("EMPTY FIELD");
				code = 400;
				responseDTO.setStatus(code);
			} else {
				code = 200;
				responseDTO.setMessage("OK");
				responseDTO.setStatus(code);
				responseDTO.setData(studentDataService.editStudent(student));
			}
		} else {
			code = 404;
			responseDTO.setMessage("ID Not Found");
			responseDTO.setStatus(code);
			responseDTO.setData("Student Id didn't exist");
		}

		return new ResponseEntity<>(responseDTO, HttpStatusCode.valueOf(code));
	}

	// ============================= Adding Book in Student
	// Data========================
	@PutMapping("/book")
	@ResponseBody
	public ResponseEntity<Object> book(@RequestParam("studentId") long studentId, @RequestParam("bookId") long bookId) {
		// studentDataService.addBook(studentId, bookId);

		/*
		 * responseDTO.setData("Book Data added"); responseDTO.setMessage("ADDED");
		 * responseDTO.setStatus(201);
		 */

		if (studentId == 0) {
			responseDTO.setData("Please enter the value of Student's ID");
			responseDTO.setMessage("EMPTY FIELD");
			code = 400;
			responseDTO.setStatus(code);
		} else if (bookId == 0) {
			responseDTO.setData("Please enter the value " + "" + "" + " Book's ID");
			responseDTO.setMessage("EMPTY FIELD");
			code = 400;
			responseDTO.setStatus(code);
		} else if (!(studentDataRepository.existsById(studentId))) {
			responseDTO.setData("Student ID NOT FOUND please enter valid ID");
			responseDTO.setMessage("ID NOT FOUND ");
			code = 404;
			responseDTO.setStatus(code);
		} else if (!(bookDataRepository.existsById(bookId))) {
			responseDTO.setData("Book ID NOT FOUND please enter valid ID");
			responseDTO.setMessage("ID NOT FOUND ");
			code = 404;
			responseDTO.setStatus(code);
		} else {
			responseDTO.setData(studentDataService.addBook(studentId, bookId));
			responseDTO.setMessage("DATA ADDED SUCCESSFULLY ");
			code = 200;
			responseDTO.setStatus(code);
		}
		return new ResponseEntity<>(responseDTO, HttpStatusCode.valueOf(code));
	}

}
