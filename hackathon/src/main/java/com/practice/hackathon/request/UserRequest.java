package com.practice.hackathon.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.practice.hackathon.entity.Address;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRequest {
	
	@NotEmpty(message="First name should not be empty or null")
	private String firstName;
	@NotEmpty(message="Last name should not be empty or null")
	private String lastName;
	@NotEmpty(message="Date of birth should not be empty or null")
	private String dateOfBirth;
	@NotEmpty(message="Nationality should not be empty or null")
	private String natinality;
	@NotEmpty(message="Gender should not be empty or null")
	private String gender;
	@NotNull(message = "Primary_contact_number should be not be empty")
	private long primary_contact_number;
	@NotNull(message = "Secondary_contact_number should be not be empty")
	private long secondary_contact_number;
	@NotNull(message = "Identification_id should be not be empty")
	private long identification_id;
	@Email
	@NotEmpty(message="Email should not be empty or null")
	private String email;
	private Address address;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getNatinality() {
		return natinality;
	}
	public void setNatinality(String natinality) {
		this.natinality = natinality;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getPrimary_contact_number() {
		return primary_contact_number;
	}
	public void setPrimary_contact_number(long primary_contact_number) {
		this.primary_contact_number = primary_contact_number;
	}
	public long getSecondary_contact_number() {
		return secondary_contact_number;
	}
	public void setSecondary_contact_number(long secondary_contact_number) {
		this.secondary_contact_number = secondary_contact_number;
	}
	public long getIdentification_id() {
		return identification_id;
	}
	public void setIdentification_id(long identification_id) {
		this.identification_id = identification_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	
	
}
