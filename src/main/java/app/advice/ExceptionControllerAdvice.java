package app.advice;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import app.exception.employee.EmployeeAlreadyExistsException;
import app.model.response.ErrorResponse;

@RestControllerAdvice
public class ExceptionControllerAdvice {
	
	@Autowired
	Environment environment;
	
	@ExceptionHandler(value=EmployeeAlreadyExistsException.class)
	public ResponseEntity<ErrorResponse> createEmployeeExceptionalHandler(EmployeeAlreadyExistsException exception){
		ErrorResponse errorResponse=new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), environment.getProperty(exception.getMessage()), LocalDateTime.now());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> genericEmployeeExceptionalHandler(Exception exception){
		ErrorResponse errorResponse=new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), environment.getProperty(exception.getMessage()), LocalDateTime.now());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
