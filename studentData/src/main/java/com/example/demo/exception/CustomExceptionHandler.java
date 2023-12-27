package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.dto.ResponseDTO;

@RestControllerAdvice
public class CustomExceptionHandler {

	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseDTO userNotFoundExceptionHandling(StudentNotFoundException ex) {
		return new ResponseDTO(500,"ERROR",ex.getMessage());
	}
	
}
