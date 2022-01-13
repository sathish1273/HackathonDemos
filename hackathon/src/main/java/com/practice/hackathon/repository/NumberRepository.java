package com.practice.hackathon.repository;
import com.practice.hackathon.entity.MobileNumber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NumberRepository extends JpaRepository<MobileNumber, Long> {
    List<MobileNumber> findByAvailability(String availability);
    Optional<MobileNumber> findByNumberIdAndAvailability(long id,String availability);
}
