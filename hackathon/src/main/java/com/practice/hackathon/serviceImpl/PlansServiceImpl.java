package com.practice.hackathon.serviceImpl;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.hackathon.entity.MobileNumber;
import com.practice.hackathon.entity.Plan;
import com.practice.hackathon.repository.NumberRepository;
import com.practice.hackathon.repository.PlansRepository;
import com.practice.hackathon.service.PlansService;

@Service
public class PlansServiceImpl implements PlansService {

    @Autowired
    PlansRepository repository;

    @Autowired
    NumberRepository numberRepository;

    @Override
    public String savePlan(Plan plan) {
         repository.save(plan);
         return "PLAN SAVED";
    }

    @Override
    public List<Plan> getAllPlans() {
        return repository.findAll();
    }

    @Override
    public List<MobileNumber> getAllNumbers() {
        List<MobileNumber> numbers = new ArrayList<>();
        int check = 0;
        for (MobileNumber numbersIteration : numberRepository.findByAvailability("Y")) {
            if (check>=10) {
                break;
            }
            numbers.add(numbersIteration);
            check = check+1;
        }
        return numbers;
    }

    @Override
    public String saveAllNumbers() {
        Long number = 9788119400L;
        for (int i = 1; i<100; i++) {
            number = number + i;
            numberRepository.save(new MobileNumber(i, number, "Y"));
        }
        return "Saved 100 Numbers";
    }

    @Override
    public String updateAvailabilityOfNumber(int numberId) {
        MobileNumber number = numberRepository.findById(numberId).get();
        number.setAvailability("N");
        numberRepository.save(number);
        return "NUMBER OCCUPIED";
    }
}
