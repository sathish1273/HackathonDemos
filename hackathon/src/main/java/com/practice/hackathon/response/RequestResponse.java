package com.practice.hackathon.response;

import com.practice.hackathon.dto.RequestStatus;

public class RequestResponse {
	
	private RequestStatus RequestStatus;
	private long requestId;
	public RequestStatus getRequestStatus() {
		return RequestStatus;
	}
	public void setRequestStatus(RequestStatus requestStatus) {
		RequestStatus = requestStatus;
	}
	public long getRequestId() {
		return requestId;
	}
	public void setRequestId(long requestId) {
		this.requestId = requestId;
	}
	public RequestResponse(com.practice.hackathon.dto.RequestStatus requestStatus, long requestId) {
		super();
		RequestStatus = requestStatus;
		this.requestId = requestId;
	}
	
	

}
