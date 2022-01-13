package com.practice.hackathon.exceptions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.practice.hackathon.dto.BusinessMessage;
import com.practice.hackathon.dto.StatusEnum;

public class CustomExceptionSchema {

	private StatusEnum apiStatus;
	private String message;
	private LocalDateTime timeStamp;
	private List<BusinessMessage> BusinessMessageList= new ArrayList<BusinessMessage>();

	public StatusEnum getApiStatus() {
		return apiStatus;
	}

	public void setApiStatus(StatusEnum apiStatus) {
		this.apiStatus = apiStatus;
	}

	public List<BusinessMessage> getBusinessMessageList() {
		return BusinessMessageList;
	}

	public void setBusinessMessageList(List<BusinessMessage> businessMessageList) {
		BusinessMessageList = businessMessageList;
	}

	protected CustomExceptionSchema() {}

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

	public CustomExceptionSchema(StatusEnum apiStatus, String message, LocalDateTime timeStamp,
			List<BusinessMessage> businessMessageList) {
		super();
		this.apiStatus = apiStatus;
		this.message = message;
		this.timeStamp = timeStamp;
		BusinessMessageList = businessMessageList;
	}

	

	 
	  
}
