package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Course;
import com.example.demo.model.Video;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{

	@Query(value = "select * from course where category_id = ?", nativeQuery = true) 
	  public List<Course> getCourseByCategory(int id);
	
}
