package com.practice.hackathon.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.practice.hackathon.dto.StatusEnum;
import com.practice.hackathon.repository.UserRepository;
import com.practice.hackathon.response.Response;
import com.practice.hackathon.service.UserService;

@ExtendWith(SpringExtension.class)
public class UserControllerTest {
	
//	@Autowired(required = true)
//	UserService userService1;

//    @Autowired
//    MockMvc mockMvc;
    
//    @Test
//    public void testgetUser() throws Exception
  //  {
//    	Mockito.when(userService1.getUser(2)).thenReturn(new Response());
//    	mockMvc.perform(get("/users/getuser?userId=2"))
//        .andExpect(status().isOk());
       // .andExpect(jsonPath("$", Matchers.hasSize(1)))
       // .andExpect(jsonPath("$[0].firstName", Matchers.is("Lokesh")));
    // }
    
    @InjectMocks
    UserController userController;
    
    @Mock
    UserService userService;
    
    @Mock
	UserRepository userRepository;
    
    @Test
    public void testGetUser() throws Exception
    {
    	Response res = new Response();
    	res.setApiStatus(StatusEnum.SUCCESS);
		Mockito.when(userService.getUser(Mockito.anyLong())).thenReturn(res);
    	ResponseEntity<Response> response=userController.getUser(1);
    	assertNotNull(response);
    }
}
