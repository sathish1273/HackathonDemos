package com.practice.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.hackathon.entity.Address;

@Repository
public interface AddressrRepository extends JpaRepository<Address, Long> {

}
