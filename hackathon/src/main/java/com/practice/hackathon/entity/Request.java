package com.practice.hackathon.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Request {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long requestId;
	private long planId;
	private long userId;
	private long mobileNumber;
	private String requestStatus;
	private String comments;
	public long getRequestId() {
		return requestId;
	}
	public void setRequestId(long requestId) {
		this.requestId = requestId;
	}
	public long getPlanId() {
		return planId;
	}
	public void setPlanId(long planId) {
		this.planId = planId;
	}
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Request(long planId, long userId, long mobileNumber, String requestStatus,
			String comments) {
		super();
		this.planId = planId;
		this.userId = userId;
		this.mobileNumber = mobileNumber;
		this.requestStatus = requestStatus;
		this.comments = comments;
	}
	
	public Request() {
		
	}
}
