package com.practice.hackathon.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Request {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long requestId;
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "planId", insertable = true, updatable = true)
	private Plan planId;
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId", insertable = true, updatable = true)
	private User userId;
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "numberId", insertable = true, updatable = true)
	private MobileNumber mobileNumber;
	private String requestStatus;
	private String comments;
	public long getRequestId() {
		return requestId;
	}
	public void setRequestId(long requestId) {
		this.requestId = requestId;
	}
	public Plan getPlanId() {
		return planId;
	}
	public void setPlanId(Plan planId) {
		this.planId = planId;
	}
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	public MobileNumber getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(MobileNumber mobileNumber) {
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
	public Request(Plan planId, User userId, MobileNumber mobileNumber, String requestStatus, String comments) {
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
