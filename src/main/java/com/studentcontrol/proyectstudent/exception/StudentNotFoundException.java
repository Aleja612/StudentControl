package com.studentcontrol.proyectstudent.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;



@ResponseStatus(HttpStatus.NOT_FOUND)
public class StudentNotFoundException extends Exception {

	public StudentNotFoundException(String message) {
		super(message);
	}
}
