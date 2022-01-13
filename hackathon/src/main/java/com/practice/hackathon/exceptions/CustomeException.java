package com.practice.hackathon.exceptions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.practice.hackathon.dto.BusinessMessage;

public class CustomeException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private String message;
	private LocalDateTime timeStamp=LocalDateTime.now();
	private HttpStatus httpStatus;
	private List<BusinessMessage> BusinessMessageList= new ArrayList<BusinessMessage>();
	

	public List<BusinessMessage> getBusinessMessageList() {
		return BusinessMessageList;
	}


	public void setBusinessMessageList(List<BusinessMessage> businessMessageList) {
		BusinessMessageList = businessMessageList;
	}


	public HttpStatus getHttpStatus() {
		return httpStatus;
	}


	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}


	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}


	public CustomeException(String message,List<BusinessMessage> BusinessMessageList, HttpStatus httpStatus) {
		super();
		this.message = message;
		this.httpStatus = httpStatus;
		this.BusinessMessageList = BusinessMessageList;
	}

	public CustomeException() {
		
	}
	
	}
