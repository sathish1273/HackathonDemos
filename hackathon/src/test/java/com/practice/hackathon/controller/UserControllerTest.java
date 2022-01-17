package com.practice.hackathon.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
 
import java.util.Arrays;
import java.util.List;
 
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.practice.hackathon.response.Response;
import com.practice.hackathon.service.UserService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {
	
//	@Autowired(required = true)
//	UserService userService1;

    @Autowired
    MockMvc mockMvc;
    
//    @Test
//    public void testgetUser() throws Exception
  //  {
//    	Mockito.when(userService1.getUser(2)).thenReturn(new Response());
//    	mockMvc.perform(get("/users/getuser?userId=2"))
//        .andExpect(status().isOk());
       // .andExpect(jsonPath("$", Matchers.hasSize(1)))
       // .andExpect(jsonPath("$[0].firstName", Matchers.is("Lokesh")));
    // }
}
