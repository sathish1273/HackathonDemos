package com.practice.hackathon.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MobileNumber {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private long numberId;
    private Long number;
    private String availability;

   public long getNumberId() {
      return numberId;
   }

   public void setNumberId(long numberId) {
      this.numberId = numberId;
   }

   public Long getNumber() {
      return number;
   }

   public void setNumber(Long number) {
      this.number = number;
   }

   public String getAvailability() {
      return availability;
   }

   public void setAvailability(String availability) {
      this.availability = availability;
   }

   public MobileNumber() {
   }

   public MobileNumber(int numberId, Long number, String availability) {
      super();
      this.numberId = numberId;
      this.number = number;
      this.availability = availability;
   }

}
