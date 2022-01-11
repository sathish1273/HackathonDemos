package com.practice.hackathon.service;

import com.practice.hackathon.request.UserRequest;
import com.practice.hackathon.response.Response;

public interface UserService {

	public Response addUser(UserRequest userRequest);
	public Response getUser(long userId);
}
