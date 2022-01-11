package com.practice.hackathon.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long userId;
	
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String natinality;
	private String gender;
	private long primary_contact_number;
	private long secondary_contact_number;
	private long identificationId;
	private byte[] identification_proof;
	private String email;
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "addressId", insertable = true, updatable = true)
	private Address address;

	

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public void setIdentification_id(long identification_id) {
		this.identificationId = identification_id;
	}

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
		return identificationId;
	}

	public void setIdentification_id(int identification_id) {
		this.identificationId = identification_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte[] getIdentification_proof() {
		return identification_proof;
	}

	public void setIdentification_proof(byte[] identification_proof) {
		this.identification_proof = identification_proof;
	}

	

	public long getIdentificationId() {
		return identificationId;
	}

	public void setIdentificationId(long identificationId) {
		this.identificationId = identificationId;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public User(String firstName, String lastName, String dateOfBirth, String natinality, String gender,
			long primary_contact_number, long secondary_contact_number, long identification_id,
			byte[] identification_proof, String email, Address address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.natinality = natinality;
		this.gender = gender;
		this.primary_contact_number = primary_contact_number;
		this.secondary_contact_number = secondary_contact_number;
		this.identificationId = identification_id;
		this.identification_proof = identification_proof;
		this.email = email;
		this.address = address;
	}
	
	
	public User() {
		
	}
	
}
