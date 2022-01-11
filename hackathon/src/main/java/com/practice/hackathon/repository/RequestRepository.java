package com.practice.hackathon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.hackathon.entity.Request;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {
	
	public Request findByUserId(long userId);
	public List<Request> findByRequestStatus(String status);

}
