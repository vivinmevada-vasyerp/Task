package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "book_data")
public class BookData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bookId;
	//@OneToMany(cascade = CascadeType.ALL)
	private String bookName;
	private String bookDesc;
	
	//@OneToOne
	/* @JoinColumn(name = "student_id") */
	//private StudentData studentData;

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookDesc() {
		return bookDesc;
	}

	public void setBookDesc(String bookDesc) {
		this.bookDesc = bookDesc;
	}

	/*
	 * public StudentData getStudentData() { return studentData; }
	 * 
	 * public void setStudentData(StudentData studentData) { this.studentData =
	 * studentData; }
	 */

	@Override
	public String toString() {
		return "BookData [bookId=" + bookId + ", bookName=" + bookName + ", bookDesc=" + bookDesc + ", ]";
	}
	
	
}
