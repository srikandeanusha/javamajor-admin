package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Feedback;
import com.example.demo.model.Profile;
import com.example.demo.model.User;
import com.example.demo.service.AdminService;

@RestController
@RequestMapping("/elearning")
public class UserController {

	@Autowired AdminService adminService;
	
	//user registration
		@PostMapping("/user/{type}")
		public String addUser(@RequestBody User user,@PathVariable String type) {
			adminService.addUser(user,type);
			return "user added";
		}
		
		//to get the all user
		@GetMapping("/user")
		public List<User> getAllUser(){
			List<User> userList = adminService.getAllUser();
			return userList;
		}
		
		//get user by id
		@GetMapping("/user/{id}")
		public User getUserById(@PathVariable int id){
			User user = adminService.getUserById(id);
			return user;
		}
		
		//for the enrollment
		@PostMapping("user/enroll")
		public String enrollAllUser(@RequestParam int userid) {
			adminService.enrollAllUser(userid);
			return "user enrolled";
		}
		
		//to add the user profile
		@PostMapping("user/profile/{id}")
		public String addProfile(@RequestBody Profile profile,@PathVariable int id) {
			adminService.addProfile(profile,id);
			return "profile added";
		}
		
		//to add the course into cart
		
		@PostMapping("user/addtocart")
		public String addToCart(@RequestParam int userid,@RequestParam int courseid) {
			adminService.addToCart(userid,courseid);
			return "course added to cart";
		}
		
		//to remove course from cart
		@DeleteMapping("user/removecart")
		public String deleteFromCart(@RequestParam int userid,@RequestParam int courseid) {
			adminService.removeFromCart(userid,courseid);
			return "course REmoved from cart";
		}
		
		//to add likes
		@PostMapping("user/like")
		public String addCourseLike(@RequestParam int userid,@RequestParam int courseid) {
			adminService.addCourseLike(userid,courseid);
			return "likes added";
		}
		
		@PostMapping("user/feedback/{userid}/{courseid}")
		public String addFeedback(@RequestBody Feedback feedback,@PathVariable int userid,@PathVariable int courseid) {
			adminService.addFeedback(feedback,userid,courseid);
			return "feedback added";
		}
		
		@PostMapping("user/addlike/{userid}/{courseid}")
			public String addLike(@PathVariable int userid, @PathVariable int courseid) {
				
			adminService.addCourseLike(userid, courseid);
				return "like added";
			}
		
		
}
