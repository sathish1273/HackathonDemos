package com.practice.hackathon.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.practice.hackathon.dto.StatusEnum;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {
	
	@org.springframework.web.bind.annotation.ExceptionHandler(value = CustomeException.class)
	public final ResponseEntity<Object> exception(CustomeException ex) {
		 CustomExceptionSchema exceptionResponse =
			        new CustomExceptionSchema(
			        		StatusEnum.FAIL, ex.getMessage(), ex.getTimeStamp(), ex.getBusinessMessageList());		   
		return new ResponseEntity<>(exceptionResponse, ex.getHttpStatus());
	}
}
