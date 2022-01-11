package com.practice.hackathon.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.hackathon.entity.MobileNumber;
import com.practice.hackathon.entity.Plan;
import com.practice.hackathon.serviceImpl.PlansServiceImpl;

@RestController
public class PlansController {

    @Autowired
    PlansServiceImpl service;

    @PostMapping("/Plan")
    public String savePlan(@Valid @RequestBody Plan plan) {
        return service.savePlan(plan);
    }

    @GetMapping("/Plans")
    public List<Plan> getAllPlans() {
        return service.getAllPlans();
    }

    @GetMapping("/Numbers")
    public List<MobileNumber> getAllNumbers() {
        return service.getAllNumbers();
    }

    @PostMapping("/Numbers")
    public String saveAllNumbers() {
        return service.saveAllNumbers();
    }

    @PutMapping("/Numbers")
    public String updateAvailabilityOfNumber(@RequestParam int numberId) {
        return service.updateAvailabilityOfNumber(numberId);
    }
}
