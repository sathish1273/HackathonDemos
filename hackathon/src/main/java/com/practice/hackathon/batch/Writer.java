package com.practice.hackathon.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.practice.hackathon.entity.User;
import com.practice.hackathon.repository.UserRepository;


@Component
public class Writer implements ItemWriter<User>{
	
	@Autowired
	private UserRepository repo;

	@Override
	@Transactional
	public void write(List<? extends User> users) throws Exception {
		repo.saveAll(users);
	}
	
}
