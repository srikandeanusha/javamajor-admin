package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video, Integer>{

	@Query(value = "select * from video where course_id = ?", nativeQuery = true) 
	  public List<Video> getVideoByCourse(int id);
	
}
