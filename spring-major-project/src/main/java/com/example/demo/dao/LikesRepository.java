package com.example.demo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Likes;

@Repository
public interface LikesRepository extends JpaRepository<Likes, Integer>{
	
	@Query(value = "select * from likes where use_id=? and course_id=?",nativeQuery = true)
	Optional<Likes> getLike(int user, int courseid);

}
