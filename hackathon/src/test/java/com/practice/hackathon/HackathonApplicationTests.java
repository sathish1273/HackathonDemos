package com.practice.hackathon;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.practice.hackathon.controller.UserController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class HackathonApplicationTests {

	@Autowired
	UserController userController;
	
	@Test
	void contextLoads() {
		//Assertions.assertThat(userController).isNot(null);
		assertNotNull(userController);
	}

}
