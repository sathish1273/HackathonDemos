package com.practice.hackathon.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.practice.hackathon.dto.BusinessMessage;
import com.practice.hackathon.dto.StatusEnum;
import com.practice.hackathon.entity.User;
import com.practice.hackathon.exceptions.CustomeException;
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
	
	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;
	
	@Override
	public Response addUser(UserRequest userRequest) {
		Response response=new Response();
		List<BusinessMessage> businessMessageList= validateRequest(userRequest);
		if(businessMessageList.isEmpty())
		{
			List<User> user1=getUserByIdentificationId(userRequest.getIdentification_id());
			if(!user1.isEmpty())
			{
				businessMessageList.add(new BusinessMessage("User already registered."));
				throw new CustomeException(StatusEnum.ALREADY_EXISTED.toString(),businessMessageList,HttpStatus.CONFLICT);
			}
			    User user=new User();
				BeanUtils.copyProperties(userRequest, user);
				user.setLastName(bcryptEncoder.encode(userRequest.getLastName()));
				user=userRepository.save(user);
				if(!Objects.isNull(user)){
					businessMessageList.add(new BusinessMessage("Successfully inserted."));
					response.setBusinessMessage(businessMessageList);
					response.setApiStatus(StatusEnum.SUCCESS);
					response.setResponseData(new UserResponse(user.getUserId()));
					return response;
				}		
		}
		else {
			throw new CustomeException(StatusEnum.NOT_FOUND.toString(), businessMessageList, HttpStatus.BAD_REQUEST);
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
		List<BusinessMessage> buisinessMessage= new ArrayList<BusinessMessage>();
		Optional<User> user=userRepository.findByUserId(userId);
		if(user.isPresent())
		{
			response.setApiStatus(StatusEnum.SUCCESS);
			response.setResponseData(user.get());
		}
		else {
			buisinessMessage.add(new BusinessMessage("User Not Found.."));
			throw new CustomeException(StatusEnum.NOT_FOUND.toString(),buisinessMessage,HttpStatus.NOT_FOUND);
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

	@Override
	public User getUser(String userName) {
		User user=userRepository.findByFirstName(userName);
		return user;
	}

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//		User user = userRepository.findByFirstName(username);
//		if(user == null){
//			throw new UsernameNotFoundException("Invalid username or password.");
//		}
//		return new org.springframework.security.core.userdetails.User(user.getFirstName(), user.getFirstName(), getAuthority());
//	}
//	
//	private List<SimpleGrantedAuthority> getAuthority() {
//		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
//	}

	
}
