package com.vsnp.punjulu.handler;

import java.time.LocalTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.vsnp.punjulu.exception.CustomerNotFoundException;
import com.vsnp.punjulu.pojo.ErrorMessage;

@RestControllerAdvice
public class CustomExceptionHadler {

	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ErrorMessage> employeeException(CustomerNotFoundException e) {
		// return ResponseEntity.internalServerError().body(e.getMessage());
		return new ResponseEntity<ErrorMessage>(
				new ErrorMessage(e.getMessage(), LocalTime.now().toString(), HttpStatus.INTERNAL_SERVER_ERROR.name()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
