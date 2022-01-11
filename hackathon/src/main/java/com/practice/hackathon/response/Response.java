package com.practice.hackathon.response;

import java.util.List;

import com.practice.hackathon.dto.BusinessMessage;
import com.practice.hackathon.dto.StatusEnum;

public class Response {
	
	private StatusEnum apiStatus;
	private List<BusinessMessage> businessMessage;	
	private Object responseData;
	public List<BusinessMessage> getBusinessMessage() {
		return businessMessage;
	}
	public void setBusinessMessage(List<BusinessMessage> businessMessage) {
		this.businessMessage = businessMessage;
	}
	
	public StatusEnum getApiStatus() {
		return apiStatus;
	}
	public void setApiStatus(StatusEnum apiStatus) {
		this.apiStatus = apiStatus;
	}
	public Object getResponseData() {
		return responseData;
	}
	public void setResponseData(Object responseData) {
		this.responseData = responseData;
	}
	
	

}
