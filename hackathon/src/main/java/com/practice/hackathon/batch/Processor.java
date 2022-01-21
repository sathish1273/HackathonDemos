package com.practice.hackathon.batch;

import java.util.Optional;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.practice.hackathon.entity.User;
import com.practice.hackathon.repository.UserRepository;


@Component
public class Processor implements ItemProcessor<User, User> {

	@Autowired
	private UserRepository userRepo;

	@Override
	public User process(User user) throws Exception {
		Optional<User> userFromDb = userRepo.findById(user.getUserId());
		if(userFromDb.isPresent()) {
			//user.setAccount(user.getAccount().add(userFromDb.get().getAccount()));
		}
		return user;
	}

}
