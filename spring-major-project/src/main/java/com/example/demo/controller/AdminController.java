package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.DtoCourse;
import com.example.demo.model.*;
import com.example.demo.service.AdminService;

@CrossOrigin
@RestController
@RequestMapping("/elearning")
public class AdminController {

	@Autowired AdminService adminService;
	
	// add category
	@PostMapping("/category")
	public String addCategory(@RequestBody Category category) 
	{
		adminService.addCategory(category);
		return "category added";
	}
	
	//to get all category
	@GetMapping("/category")
	public List<Category> getAllCategory()
	{
		List<Category> categoryList = adminService.getAllCategory();
		return categoryList;
	}
	
	//to get category by id
	@GetMapping("/category/{id}")
	public Optional<Category> getCategory(@PathVariable int id)
	{
		 Optional<Category> category = adminService.getCategory(id);
		return category;
	}
	
	//to delete category
	@DeleteMapping("/category/{id}")
	public String deleteCategory(@PathVariable int id)
	{
		adminService.deleteCategory(id);
		return "category deleted";
	}
	
	//to update category
	@PutMapping("/category/{id}")
	public String updateCategory(@PathVariable int id, @RequestBody Category category) 
	{
		System.out.println(id);
		System.out.println(category);
		adminService.updateCategory(id, category);
		return "category updated";
	}
	
	
	//to add course
	@PostMapping("/course/{id}")
	public String addCourse( @PathVariable int id,@RequestBody DtoCourse course)
	{
		System.out.println("----------------->"+course+"------------------>"+id);
	
		adminService.addCourse(id,course);
		return "course added";
	}
	
	//get all courses by category id
	@GetMapping("/course/{id}")
	public List<Course> getCourseByCatId(@PathVariable int id)
	{
		List<Course> course = adminService.getCourseByCat(id);
		return course;
	}
	
	//sort listed course
	@GetMapping("/display/{id}")
	public List<Course> getCourseByCatIdForDisplay(@PathVariable int id)
	{
		List<Course> course = adminService.getCourseByCatForDisplay(id);
		return course;
	}
	
	//to get all course
	@GetMapping("/course")
	public List<Course> getAllCourses()
	{
		List<Course> courseList = adminService.getAllCourses();
		return courseList;
	}
	
	//get Course by course id
	@GetMapping("/courseid/{id}")
	public Course getCourseById(@PathVariable int id)
	{
		Course course = adminService.getCourseByCourseId(id);
		return course;
	}
		
	//to update course
	@PutMapping("/course/{id}")
	public String updateCourse(@PathVariable int id, @RequestBody Course course) 
	{
		System.out.println(id);
		System.out.println(course);
		adminService.updateCourse(id, course);
		return "course updated";
	}
	
	//to delete course
	@DeleteMapping("/course/{id}")
	public String deleteCourse(@PathVariable int id) {
		adminService.deleteCourse(id);
		return "course deleted";
	}
	
	//to add video
	@PostMapping("/video/{id}")
	public String addVideo( @PathVariable int id,@RequestBody Video video) {
		System.out.println("Amer"+video+id);
		adminService.addVideo(id,video);
		return "video added";
	}
	
	//to delete video
	@DeleteMapping("/video/{id}")
	public String deleteVideo(@PathVariable int id) {
		adminService.deleteVideo(id);
		return "video deleted";
	}
	
	//to update video
	@PutMapping("/video/{id}")
	public String updateVideo(@PathVariable int id, @RequestBody Video video) 
	{
		System.out.println(id);
		System.out.println(video);
		adminService.updateVideo(id, video);
		return "video updated";
	}
	//to get video
	@GetMapping("/video/{id}")
	public Optional<Video> getVideoById(@PathVariable int id)
	{
		Optional<Video> video= adminService.getVideo(id);
		return video;
	}
	
	//to get All video
	@GetMapping("/video")
	public List<Video> getAllVideo(){
		List<Video> videoList = adminService.getAllVideo();
		return videoList;
	}
	
	//sort listed course
		@GetMapping("/videolist/{id}")
		public List<Video> getVideoByCourseId(@PathVariable int id)
		{
			List<Video> video = adminService.getVideoByCourseId(id);
			return video;
		}
	
	@GetMapping("/popularCourse")
	public List<Course> getPopularCourse(){
		List<Course> courseList = adminService.getPopularCourse();
		return courseList;
	}
	
	
	
	
	
	
	
	
	
	
}
