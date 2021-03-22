package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Profile;
import com.example.demo.model.User;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {
	
	Profile findByUser(User u);
	

}
