package com.practice.hackathon.controller;

import java.util.Objects;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.hackathon.dto.StatusEnum;
import com.practice.hackathon.request.UserRequest;
import com.practice.hackathon.response.Response;
import com.practice.hackathon.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
@Validated
public class UserController {
	
	private static final org.slf4j.Logger LOGGER=LoggerFactory.getLogger(UserController.class);
	
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
			LOGGER.info("success");
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
			LOGGER.info("success");
			httpstatus=HttpStatus.OK;
		}
		return new ResponseEntity<>(response,httpstatus);
		
	}

}
