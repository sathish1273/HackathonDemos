package com.practice.hackathon.response;

public class UserResponse {
	
	private long userId;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public UserResponse(long userId) {
		super();
		this.userId = userId;
	}
	
	UserResponse(){
		
	}

}
