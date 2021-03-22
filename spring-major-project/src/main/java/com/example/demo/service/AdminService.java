package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.DtoCourse;
import com.example.demo.model.Category;
import com.example.demo.model.Course;
import com.example.demo.model.Feedback;
import com.example.demo.model.Profile;
import com.example.demo.model.User;
import com.example.demo.model.Video;

public interface AdminService {

	void addCategory(Category category);

	List<Category> getAllCategory();

	Optional<Category> getCategory(int id);

	void deleteCategory(int id);
	
	void updateCategory(int id,Category category);

	void addCourse(int id,DtoCourse course);
	
	void updateCourse(int id,Course course);

	List<Course> getAllCourses();

	void addVideo(int id, Video video);

	List<Video> getAllVideo();

	void deleteCourse(int id);

	void addUser(User user,String type);
	
	void updateVideo(int id,Video video);

	void deleteVideo(int id);

	void updateUserType(int id);

	void enrollUser(int userid, int courseid);

	List<User> getAllUser();

	void addProfile(Profile profile, int id);
	
	
	 User getUserById(int id);

	void addToCart(int userid, int courseid);

	void removeFromCart(int userId, int courseId);

	void addCourseLike(int userid,int courseid);

	List<Course> getPopularCourse();

	void addFeedback(Feedback feedback, int userid,int courseid);

	List<Course> getCourseByCat(int id);
	
	void enrollAllUser(int userid);
	 List<Course> setAvgRating(List<Course> courseList);

	Course getCourseByCourseId(int courseId);

	Optional<Video> getVideo(int id);

	public  List<Course> getCourseByCatForDisplay(int id);
	
	public  List<Video> getVideoByCourseId(int id);
	
	
	
	
		

	
}
