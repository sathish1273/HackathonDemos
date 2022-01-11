package com.practice.hackathon.controller;

import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	//@Scheduled(fixedRate = 5000)
	@Scheduled(cron = "0 0/2 * * * ?")
	public void ScheduledFixedRate() 
	{
		System.out.println("I will execute after every 2 min");
		requestService.connectionEnabled();
	}
	
	@PutMapping("/requestreview")
	public String updateRequest(@Valid @RequestParam("requestId") long requestId, @RequestParam("status") String status)
	{
	return requestService.updateRequest(requestId, status);
	}
	
	@GetMapping("/requests")
	public ResponseEntity<Response> requestList()
	{
		Response response= requestService.requestList();
		return new ResponseEntity<>(response,HttpStatus.OK);
	}

}
