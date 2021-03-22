package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("prime")
public class PrimeUser extends User{


	
	public PrimeUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public PrimeUser(int id, String username, String email, int mobileNo, String status, Profile profile,List<Certificate> certificate) {
		super(id, username, email, mobileNo, status, profile, certificate);
		// TODO Auto-generated constructor stub
	}


	public PrimeUser build() {
		return new PrimeUser(id, username, email, mobileNo, status, profile,certificate);
	}

	
}
