package com.practice.hackathon.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
public class UserControllerTest {
	
	@Autowired
    private MockMvc mockMvc;
 
    private static ObjectMapper mapper = new ObjectMapper();
    
    @Test
    private void testgetUser() throws Exception
    { 
    	RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
			"/users/getuser").accept(
			MediaType.APPLICATION_JSON);

	MvcResult result = mockMvc.perform(requestBuilder).andReturn();

	System.out.println(result.getResponse());
	String expected = "{id:Course1,name:Spring,description:10Steps}";

	// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}

//	JSONAssert.assertEquals(expected, result.getResponse()
//			.getContentAsString(), false);
}
}
