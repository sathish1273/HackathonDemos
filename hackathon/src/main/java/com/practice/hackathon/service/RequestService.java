package com.practice.hackathon.service;

import javax.validation.Valid;

import com.practice.hackathon.request.RequestData;
import com.practice.hackathon.response.Response;

public interface RequestService {
	
	public Response addrequest(RequestData requestData);
	String updateRequest(@Valid long requestId, String status);

}
