package com.practice.hackathon.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.hackathon.dto.BusinessMessage;
import com.practice.hackathon.dto.RequestStatus;
import com.practice.hackathon.dto.StatusEnum;
import com.practice.hackathon.entity.Request;
import com.practice.hackathon.entity.User;
import com.practice.hackathon.repository.RequestRepository;
import com.practice.hackathon.repository.UserRepository;
import com.practice.hackathon.request.RequestData;
import com.practice.hackathon.response.RequestResponse;
import com.practice.hackathon.response.Response;
import com.practice.hackathon.service.RequestService;

@Service
public class RequestServiceImpl implements RequestService {

	@Autowired
	RequestRepository requestRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public Response addrequest(RequestData requestData) {
		Response response=new Response();
		List<BusinessMessage> BusinessMessageList= validateRequest(requestData);
		if(BusinessMessageList.isEmpty())
		{
			Request request=new Request(requestData.getPlanId(), requestData.getUserId(), requestData.getMobileNumber(), RequestStatus.INPROGRESS.toString(), null);
			request=requestRepository.save(request);
			if(!Objects.isNull(request))
			{
				BusinessMessageList.add(new BusinessMessage("Request has been submitted successfully."));
				response.setBusinessMessage(BusinessMessageList);
				response.setApiStatus(StatusEnum.SUCCESS);
				response.setResponseData(new RequestResponse(RequestStatus.INPROGRESS, request.getRequestId()));
				return response;
			}
			else {
				BusinessMessageList.add(new BusinessMessage("Problem with the request"));
				response.setBusinessMessage(BusinessMessageList);
				response.setApiStatus(StatusEnum.FAIL);
			}
		}
		response.setBusinessMessage(BusinessMessageList);
		response.setApiStatus(StatusEnum.FAIL);
		return response;
	}
	
	private List<BusinessMessage> validateRequest(RequestData requestData) {
		List<BusinessMessage> BusinessMessageList=new ArrayList<BusinessMessage>();
		Request request=requestRepository.findByUserId(requestData.getUserId());
		if(!Objects.isNull(request))
		{
			BusinessMessageList.add(new BusinessMessage("Request is already existed."));
			return BusinessMessageList;
		}
		Optional<User> user=userRepository.findByUserId(requestData.getUserId());
		if(user.isPresent())
		{
			return BusinessMessageList;
		}
		BusinessMessageList.add(new BusinessMessage("User not existed with UserIdentificationId"));
		return BusinessMessageList;
	}

}
