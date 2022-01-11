package com.practice.hackathon.controller;

import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.hackathon.dto.StatusEnum;
import com.practice.hackathon.request.RequestData;
import com.practice.hackathon.response.Response;
import com.practice.hackathon.service.RequestService;

@RestController
public class RequestController {
	
	@Autowired(required=true)
	RequestService requestService;
	
	@PostMapping("/createuserrequest")
	public ResponseEntity<Response> addRequest(@Valid @RequestBody RequestData requestData)
	{
		HttpStatus httpstatus=null;
		Response response= requestService.addrequest(requestData);
		if(!Objects.isNull(response) && !response.getApiStatus().equals(StatusEnum.SUCCESS)) {
			httpstatus=HttpStatus.NOT_FOUND;
		}
		else {
			httpstatus=HttpStatus.OK;
		}
		return new ResponseEntity<>(response,httpstatus);
	}

}
