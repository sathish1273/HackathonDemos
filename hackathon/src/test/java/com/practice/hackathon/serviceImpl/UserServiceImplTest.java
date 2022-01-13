package com.practice.hackathon.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.practice.hackathon.entity.User;
import com.practice.hackathon.repository.UserRepository;
import com.practice.hackathon.response.Response;

@ExtendWith(SpringExtension.class)
public class UserServiceImplTest {
	
	@InjectMocks
	UserServiceImpl userServiceImpl;

	@Mock
	UserRepository userRepository;
	
	//@Autowired(required=true)
	//UserService userService;
	
	@Test
	public void testgetUser() {
		User user = new User();
		user.setUserId(2);
		user.setFirstName("sathish");
		user.setLastName("U");
		Mockito.when(userRepository.findByUserId(Mockito.anyLong())).thenReturn(Optional.of(user));
		Response response = userServiceImpl.getUser(2);
		assertNotNull(response);
		
	}
	
	@Test
	public void testValidMobileNo() {
		boolean response=userServiceImpl.isValidMobileNo("8801140530");
		assertTrue(response);
	}
}
