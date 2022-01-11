package com.practice.hackathon.controller;

import com.practice.hackathon.entity.MobileNumber;
import com.practice.hackathon.serviceImpl.MobileNumberServiceImpl;
import com.practice.hackathon.serviceImpl.PlansServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MobileNumberController {

    @Autowired
    MobileNumberServiceImpl service;

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
