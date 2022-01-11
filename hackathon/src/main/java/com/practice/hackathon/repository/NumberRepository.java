package com.practice.hackathon.repository;
import com.practice.hackathon.entity.MobileNumber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NumberRepository extends JpaRepository<MobileNumber, Integer> {
    List<MobileNumber> findByAvailability(String availability);
}
