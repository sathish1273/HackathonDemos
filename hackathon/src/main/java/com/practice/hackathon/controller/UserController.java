package com.practice.hackathon.controller;

import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.hackathon.dto.StatusEnum;
import com.practice.hackathon.request.UserRequest;
import com.practice.hackathon.response.Response;
import com.practice.hackathon.service.UserService;

@RestController
@Validated
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/user")
	public ResponseEntity<Response> addUser(@Valid @RequestBody UserRequest userRequest)
	{
		HttpStatus httpstatus=null;
		Response response= userService.addUser(userRequest);
		if(!Objects.isNull(response) && !response.getApiStatus().equals(StatusEnum.SUCCESS)) {
			httpstatus=HttpStatus.NOT_FOUND;
		}
		else {
			httpstatus=HttpStatus.OK;
		}
		return new ResponseEntity<>(response,httpstatus);
	}
	
	@GetMapping("/getuser")
	public ResponseEntity<Response> getUser(@Valid @RequestParam("userId") long userId)
	{
		HttpStatus httpstatus=null;
		Response response= userService.getUser(userId);
		if(!Objects.isNull(response) && !response.getApiStatus().equals(StatusEnum.SUCCESS)) {
			httpstatus=HttpStatus.NOT_FOUND;
		}
		else {
			httpstatus=HttpStatus.OK;
		}
		return new ResponseEntity<>(response,httpstatus);
		
	}

}
