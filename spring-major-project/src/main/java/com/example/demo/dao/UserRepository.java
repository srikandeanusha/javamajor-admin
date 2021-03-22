package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;
@Repository
public interface UserRepository <T extends User>extends JpaRepository<T,Integer>{

	/*
	 * @Query(value = "update user set usertype=PrimeUser where id=?",nativeQuery =
	 * true) public void updateUserType(int id);
	 */
	

}
