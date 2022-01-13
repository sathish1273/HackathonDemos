package com.practice.hackathon.service;

import java.util.List;

import com.practice.hackathon.entity.MobileNumber;
import com.practice.hackathon.entity.Plan;

public interface PlansService {
    String savePlan(Plan plan);

    List<Plan> getAllPlans();

    List<MobileNumber> getAllNumbers();

    String saveAllNumbers();

    String updateAvailabilityOfNumber(long numberId);
}
