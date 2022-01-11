package com.practice.hackathon.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MobileNumber {

    @Id
    private int numberId;
    private Long number;
    private String availability;

   public int getNumberId() {
      return numberId;
   }

   public void setNumberId(int numberId) {
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
