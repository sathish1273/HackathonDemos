package com.practice.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.hackathon.entity.Request;
import com.practice.hackathon.entity.User;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {
	
	public Request findByUserId(long userId);

}
