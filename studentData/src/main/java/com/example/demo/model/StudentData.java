package com.example.demo.model;

import org.hibernate.annotations.Cascade;

import jakarta.*;
import jakarta.persistence.*;

/*import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;*/

@Entity
@Table(name="student_data")
public class StudentData {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long studentId;
		
		private int studentRollNumber;
		
		//@Column
		private String studentName;
		
		//@Column
		private int studentStandard;
		
		//@Column
		private String studentDivision;
		
		//@ManyToOne
		//@JoinColumn(name = "Student_id")
		@OneToOne
		private BookData bookData;

		public long getStudentId() {
			return studentId;
		}

		public void setStudentId(long studentId) {
			this.studentId = studentId;
		}

		public int getStudentRollNumber() {
			return studentRollNumber;
		}

		public void setStudentRollNumber(int studentRollNumber) {
			this.studentRollNumber = studentRollNumber;
		}

		public String getStudentName() {
			return studentName;
		}

		public void setStudentName(String studentName) {
			this.studentName = studentName;
		}

		public int getStudentStandard() {
			return studentStandard;
		}

		public void setStudentStandard(int studentStandard) {
			this.studentStandard = studentStandard;
		}

		public String getStudentDivision() {
			return studentDivision;
		}

		public void setStudentDivision(String studentDivision) {
			this.studentDivision = studentDivision;
		}

		public BookData getBookData() {
			return bookData;
		}

		public void setBookData(BookData bookData) {
			this.bookData = bookData;
		}

		@Override
		public String toString() {
			return "StudentData [studentId=" + studentId + ", studentRollNumber=" + studentRollNumber + ", studentName="
					+ studentName + ", studentStandard=" + studentStandard + ", studentDivision=" + studentDivision
					+ ", libraryData=" + bookData + "]";
		}

		
	}
	

