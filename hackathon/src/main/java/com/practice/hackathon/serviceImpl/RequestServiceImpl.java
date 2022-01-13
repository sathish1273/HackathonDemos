package com.practice.hackathon.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.practice.hackathon.dto.BusinessMessage;
import com.practice.hackathon.dto.RequestStatus;
import com.practice.hackathon.dto.StatusEnum;
import com.practice.hackathon.entity.MobileNumber;
import com.practice.hackathon.entity.Plan;
import com.practice.hackathon.entity.Request;
import com.practice.hackathon.entity.User;
import com.practice.hackathon.exceptions.CustomeException;
import com.practice.hackathon.repository.NumberRepository;
import com.practice.hackathon.repository.PlansRepository;
import com.practice.hackathon.repository.RequestRepository;
import com.practice.hackathon.repository.UserRepository;
import com.practice.hackathon.request.RequestData;
import com.practice.hackathon.response.RequestResponse;
import com.practice.hackathon.response.Response;
import com.practice.hackathon.service.RequestService;

@Service
@Transactional
public class RequestServiceImpl implements RequestService {

	@Autowired
	RequestRepository requestRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PlansRepository planRepository;
	
	@Autowired
	NumberRepository numberRepository;
	
	@Override
	public Response addrequest(RequestData requestData) {
		Response response=new Response();
		List<BusinessMessage> businessMessageList= validateRequest(requestData);
		if(businessMessageList.isEmpty())
		{
			Request request=new Request(getPlan(requestData.getPlanId()), getUser(requestData.getUserId()), getMobileNumber(requestData.getMobileNumber()), RequestStatus.INPROGRESS.toString(), null);
			request=requestRepository.save(request);
			if(!Objects.isNull(request))
			{
				MobileNumber mobileNumber=request.getMobileNumber();
				mobileNumber.setAvailability("N");
				numberRepository.save(mobileNumber);
				
				businessMessageList.add(new BusinessMessage("New Mobile Connection Request has been submitted successfully."));
				response.setBusinessMessage(businessMessageList);
				response.setApiStatus(StatusEnum.SUCCESS);
				response.setResponseData(new RequestResponse(RequestStatus.INPROGRESS, request.getRequestId()));
				return response;
			}
		}
		throw new CustomeException(StatusEnum.INPUT_INVALID.toString(), businessMessageList, HttpStatus.BAD_REQUEST);
	}
	
	private List<BusinessMessage> validateRequest(RequestData requestData) {
		getUser(requestData.getUserId());
		getPlan(requestData.getPlanId());
		getMobileNumber(requestData.getMobileNumber());
		List<BusinessMessage> businessMessageList=new ArrayList<BusinessMessage>();
//		if(!Objects.isNull(getUser(requestData.getUserId())))
//		{
//			businessMessageList.add(new BusinessMessage("Incorrect UserId"));
//		}
//		if(Objects.isNull(getPlan(requestData.getPlanId())))
//		{
//			businessMessageList.add(new BusinessMessage("Incorrect planId"));
//		}
//		if(Objects.isNull(getMobileNumber(requestData.getMobileNumber())))
//		{
//			businessMessageList.add(new BusinessMessage("Incorrect Mo"));
//		}
		
		return businessMessageList;
	}
	private User getUser(long userId)
	{
		List<BusinessMessage> businessMessageList=new ArrayList<BusinessMessage>();
		Optional<User> user=userRepository.findByUserId(userId);
		if(!user.isPresent())
		{
			businessMessageList.add(new BusinessMessage("Incorrect UserId"));
			throw new CustomeException(StatusEnum.INPUT_INVALID.toString(), businessMessageList, HttpStatus.BAD_REQUEST);
		}
		return user.get();
	}
	
	private Plan getPlan(int planId)
	{
		List<BusinessMessage> businessMessageList=new ArrayList<BusinessMessage>();
		Plan plan=planRepository.findByPlanId(planId);
		if(Objects.isNull(plan))
		{
			businessMessageList.add(new BusinessMessage("Incorrect planId"));
			throw new CustomeException(StatusEnum.INPUT_INVALID.toString(), businessMessageList, HttpStatus.BAD_REQUEST);
		}
		return plan;
	}
	
	private MobileNumber getMobileNumber(long l)
	{
		List<BusinessMessage> businessMessageList=new ArrayList<BusinessMessage>();
		Optional<MobileNumber> mobileNumber=numberRepository.findByNumberIdAndAvailability(l,"Y");
		if(!mobileNumber.isPresent())
		{
			businessMessageList.add(new BusinessMessage("Incorrect mobileNumber id.."));
			throw new CustomeException(StatusEnum.INPUT_INVALID.toString(), businessMessageList, HttpStatus.BAD_REQUEST);
		}
		return mobileNumber.get();
	}
	
	@Override
	public void connectionEnabled() {
		List<Request> requestList = requestRepository.findByRequestStatus(RequestStatus.APPROVED.toString());
		List<Request> requestLists = new ArrayList<Request>();
		requestList.forEach(r->{
			r.setRequestStatus(RequestStatus.CONNECTION_ENABLED.toString());
			requestLists.add(r);
		});	
		requestRepository.saveAll(requestLists);
	}

	
	public Request getRequestByRequestId(Long requestId) {
		Optional<Request> request = requestRepository.findById(requestId);
		if (request.isPresent()) {
		return request.get();
		}
		return null;
		}



		@Override
		public String updateRequest(@Valid long requestId, String status) {
			Request dbRequest = getRequestByRequestId(requestId);
			dbRequest.setRequestStatus(status);
			Request request = requestRepository.save(dbRequest);
			if (!Objects.isNull(request)) {
			return "Successfully updated request";
			} else {
			return "Failed to update the request";
			}
		}

		@Override
		public Response requestList() {
			Response response=new Response();
			List<Request> requestList = requestRepository.findByRequestStatus(RequestStatus.INPROGRESS.toString());
			response.setApiStatus(StatusEnum.SUCCESS);
			response.setResponseData(requestList);
			return response;
		}

}
