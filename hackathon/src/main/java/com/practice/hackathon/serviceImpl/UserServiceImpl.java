package com.practice.hackathon.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.hackathon.dto.BusinessMessage;
import com.practice.hackathon.dto.StatusEnum;
import com.practice.hackathon.entity.Address;
import com.practice.hackathon.entity.User;
import com.practice.hackathon.repository.AddressrRepository;
import com.practice.hackathon.repository.UserRepository;
import com.practice.hackathon.request.UserRequest;
import com.practice.hackathon.response.Response;
import com.practice.hackathon.response.UserResponse;
import com.practice.hackathon.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AddressrRepository addressRepository;
	
	@Override
	public Response addUser(UserRequest userRequest) {
		Response response=new Response();
		List<BusinessMessage> BusinessMessageList= validateRequest(userRequest);
		if(BusinessMessageList.isEmpty())
		{
			List<User> user1=getUserByIdentificationId(userRequest.getIdentification_id());
			if(!user1.isEmpty())
			{
				BusinessMessageList.add(new BusinessMessage("user already existed"));
				response.setBusinessMessage(BusinessMessageList);
				response.setApiStatus(StatusEnum.FAIL);
				return response;
			}
			Address address=new Address(userRequest.getAddress().getHomeNumber(), userRequest.getAddress().getBuildingNumber(), userRequest.getAddress().getStreetName(), 
					userRequest.getAddress().getLandMarks(), userRequest.getAddress().getCity(), userRequest.getAddress().getState(), userRequest.getAddress().getPincode());
			address=addressRepository.save(address);
			if(!Objects.isNull(address))
			{
				User user=new User(userRequest.getFirstName(), userRequest.getLastName(), userRequest.getDateOfBirth(), userRequest.getNatinality(), userRequest.getGender(),
						userRequest.getPrimary_contact_number(), userRequest.getSecondary_contact_number(), userRequest.getIdentification_id(), null, userRequest.getEmail(), address);
				user=userRepository.save(user);
				if(!Objects.isNull(user)){
					BusinessMessageList.add(new BusinessMessage("Successfully inserted."));
					response.setBusinessMessage(BusinessMessageList);
					response.setApiStatus(StatusEnum.SUCCESS);
					response.setResponseData(new UserResponse(user.getUserId()));
					return response;
				}
			}
			
		}
		else {
			response.setBusinessMessage(BusinessMessageList);
			response.setApiStatus(StatusEnum.FAIL);
			return response;
		}
		return response;
	}
	
	public static List<BusinessMessage> validateRequest(UserRequest request)
	{
		List<BusinessMessage> list=new ArrayList<>();
		if(!isValidMobileNo(String.valueOf(request.getPrimary_contact_number())))
			list.add(new BusinessMessage("Invalid Primary contact number"));
		if(!isValidMobileNo(String.valueOf(request.getSecondary_contact_number())))
			list.add(new BusinessMessage("Invalid secondary contact number"));
		
		return list;
	}
	
	@Override
	public Response getUser(long userId) {
		Response response=new Response();
		Optional<User> user=userRepository.findByUserId(userId);
		if(user.isPresent())
		{
			response.setApiStatus(StatusEnum.SUCCESS);
			response.setResponseData(user.get());
		}
		else {
			response.setApiStatus(StatusEnum.FAIL);
		}
		return response;
	}
	

	private List<User> getUserByIdentificationId(long IdentificationId) {
		List<User> user=userRepository.findByIdentificationId(IdentificationId);
		return user;
	}
	
	public static boolean isValidMobileNo(String str)  
	{  
	Pattern ptrn = Pattern.compile("(0/91)?[7-9][0-9]{9}"); 
	Matcher match = ptrn.matcher(str);
	return (match.find() && match.group().equals(str));  
	} 
	
	public static boolean isValidEmail(String str)  
	{
		 String regex = "^(.+)@(.+)$"; 
	     Pattern pattern = Pattern.compile(regex); 
	     Matcher matcher = pattern.matcher(str);  
	     return matcher.matches();
	}

	
}
