package org.vm93.u2w3wp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import ch.qos.logback.core.boolex.EvaluationException;

@ControllerAdvice
public class CustomExceptions extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	ResponseEntity<String> manageException(Exception e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(EvaluationException.class)
	ResponseEntity<String> manageException(EvaluationException e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
}
