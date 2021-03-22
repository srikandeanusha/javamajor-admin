package com.example.demo.model;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name ="usertype")
@DiscriminatorValue("regular")

public  class User {
	@Id		
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected int id;
	protected String username;
	protected String email;
	protected int mobileNo;
	protected String status="unblock";
	protected String role="user";
	
	
	@OneToOne(
			fetch = FetchType.LAZY, 
			cascade = CascadeType.ALL,mappedBy = "user"
			)
	protected Profile profile;

	
	@OneToMany(targetEntity = Certificate.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="userId", referencedColumnName = "id")
	protected List<Certificate> certificate;
	
	
	public User() {
		super();
	}
	
	
	public Profile getProfile() {
		return profile;
	}


	public void setProfile(Profile profile) {
		this.profile = profile;
	}


	public int getId() {
		return id;
	}
	public User setId(int id) {
		this.id = id;
		return this;
	}
	public String getUsername() {
		return username;
	}
	public User setUsername(String username) {
		this.username = username;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public User setEmail(String email) {
		this.email = email;
		return this;
	}
	public int getMobileNo() {
		return mobileNo;
	}
	public User setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
		return this;
	}
	public String getStatus() {
		return status;
	}
	public User setStatus(String status) {
		this.status = status;
		return this;
	}


	
	
	public String getRole() {
		return role;
	}


	public User setRole(String role) {
		this.role = role;
		return this;
	}

	


	public List<Certificate> getCertificate() {
		return certificate;
	}


	public User setCertificate(List<Certificate> certificate) {
		this.certificate = certificate;
		return this;
	}


	public User(int id, String username, String email, int mobileNo, String status, Profile profile,
			 List<Certificate> certificate) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.mobileNo = mobileNo;
		this.status = status;
		this.profile = profile;
		this.certificate = certificate;
	}
	
	public User build() {
		return new User(id,username,email,mobileNo,status,profile,certificate);
	}


	
	
	
	
	
}
