package com.practice.hackathon.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long addressId;
	private String homeNumber;
	private String buildingNumber;
	private String streetName;
	private String landMarks;
	private String city;
	private String state;
	private int pincode;
	
	public long getAddresId() {
		return addressId;
	}
	public void setAddresId(long addressId) {
		this.addressId = addressId;
	}
	public String getHomeNumber() {
		return homeNumber;
	}
	public void setHomeNumber(String homeNumber) {
		this.homeNumber = homeNumber;
	}
	public String getBuildingNumber() {
		return buildingNumber;
	}
	public void setBuildingNumber(String buildingNumber) {
		this.buildingNumber = buildingNumber;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getLandMarks() {
		return landMarks;
	}
	public void setLandMarks(String landMarks) {
		this.landMarks = landMarks;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public Address(String homeNumber, String buildingNumber, String streetName, String landMarks,
			String city, String state, int pincode) {
		super();
		this.homeNumber = homeNumber;
		this.buildingNumber = buildingNumber;
		this.streetName = streetName;
		this.landMarks = landMarks;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	public Address() {
		
	}

}
