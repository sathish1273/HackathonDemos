package com.practice.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.hackathon.entity.Plan;

@Repository
public interface PlansRepository extends JpaRepository<Plan, Integer> {
  
	public Plan findByPlanId(int planId);
}
