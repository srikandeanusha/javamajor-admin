package com.example.demo.dao;

import javax.transaction.Transactional;

import com.example.demo.model.PrimeUser;


@Transactional
public interface PrimeUserRepository extends UserRepository<PrimeUser> {

}
