package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Certificate;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Integer>{

}
