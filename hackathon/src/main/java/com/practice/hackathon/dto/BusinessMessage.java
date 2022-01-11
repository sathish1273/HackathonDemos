package com.practice.hackathon.dto;

public class BusinessMessage {

	private String message;

	public BusinessMessage(String string) {
		this.message=string;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
