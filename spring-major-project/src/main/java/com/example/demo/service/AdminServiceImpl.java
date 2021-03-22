package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.MethodInvocationRecorder.Recorded.ToMapConverter;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CartRepository;
import com.example.demo.dao.CategoryRepository;
import com.example.demo.dao.CourseRepository;
import com.example.demo.dao.EnrollmentRepository;
import com.example.demo.dao.LikesRepository;
import com.example.demo.dao.ProfileRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.dao.VideoRepository;
import com.example.demo.dao.VideoStatusRepository;
import com.example.demo.dto.DtoCourse;
import com.example.demo.model.*;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	CategoryRepository categoryRepo;
	@Autowired
	CourseRepository courseRepo;
	@Autowired
	VideoRepository videoRepo;
	@Autowired
	UserRepository<User> userRepo;
	@Autowired
	EnrollmentRepository enrollRepo;
	@Autowired
	ProfileRepository profileRepo;
	@Autowired
	CartRepository cartRepo;
	@Autowired
	VideoStatusRepository videoStatusRepo;
	@Autowired
	LikesRepository likesRepo;
	
	public void addCategory(Category category) {
		categoryRepo.save(category);

	}

	public List<Category> getAllCategory() {
		List<Category> category = categoryRepo.findAll();
		//List<Category> categoryList=new ArrayList<Category>();
//		for(Category c : category) {
//			categoryList.add(new Category()
//					.setCategoryId(c.getCategoryId())
//					.setCategoryName(c.getCategoryName())
//					.build());
//		}
		return category;

	}

	public Optional<Category> getCategory(int id) {
		Optional<Category> category = categoryRepo.findById(id);
		return category;
	}

	public void deleteCategory(int id) {
		categoryRepo.deleteById(id);

	}
	
	@Override
	public void updateCategory(int id, Category category) {
		Category c=new Category();
		List<Course> list=courseRepo.getCourseByCategory(id);
		c=categoryRepo.getOne(id);
		
		c.setCourses(list);
		c.setCategoryId(id);
		c.setCategoryLogo(category.getCategoryLogo());
		c.setCategoryDesc(category.getCategoryDesc());
		c.setCategoryName(category.getCategoryName());
		//fetch list of courses here and add it in category object , After that u can save 
		categoryRepo.save(c); 		
	}  
	 
//		List<Category> categoryList = getAllCategory();
		
////		for(int i=0;i<=categoryList.size();i++)
////		{
////			if(i==id)
////			{
//				categoryRepo.save(category);
//			}
//		}	
	public void addCourse(int id, DtoCourse course) {
		System.out.println("-------------------->Servioce"+course);
		Optional<Category> category = categoryRepo.findById(id);
		List<Course> courses = category.get().getCourses();
		//for adding course object 
		Course c=new Course();
		
		c.setCourseName(course.getCourseName());
		c.setCourseDesc(course.getCourseDesc());
		c.setCourseLogo(course.getCourseLogo());
		c.setCoursePrice(course.getCoursePrice());
		c.setNoOfVideo(course.getNoOfVideo());		
		courses.add(c);
		category.get().setCourses(courses);
		categoryRepo.save(category.get());

	}

	public List<Course> getAllCourses() {
		List<Course> courses = courseRepo.findAll();
			
		return setAvgRating(courses);
	}

	public void addVideo(int id, Video video) {
		Optional<Course> course = courseRepo.findById(id);
		List<Video> videoList = course.get().getVideo();
		videoList.add(video);
		course.get().setVideo(videoList);
		course.get().setNoOfVideo(videoList.size());
		Course savedcourse = courseRepo.save(course.get());
		List<Video> videoListCurr = savedcourse.getVideo();
		int videoid = videoListCurr.get(videoListCurr.size() - 1).getVideoId();
		System.out.println(videoListCurr.get(videoListCurr.size() - 1).getVideoId());

		List<Enrollment> enrollUserList = course.get().getEnrollment();
		Video video1 = videoRepo.findById(videoid).get();

		List<Videostatus> vs = new ArrayList<Videostatus>();

		for (Enrollment e : enrollUserList) {
			vs.add(new Videostatus().setUserId(e.getId()));
		}

		video1.setVideostatus(vs);
		videoRepo.save(video1);
	}

	public List<Video> getAllVideo() {
		List<Video> videoList = videoRepo.findAll();
		return videoList;
	}

	public void deleteCourse(int id) {
		courseRepo.deleteById(id);

	}
	public void updateCourse(int id,Course course) {
		Course c=new Course();
		List<Video> list=videoRepo. getVideoByCourse(id);
		c=courseRepo.getOne(id);
		
		c.setVideo(list);
		c.setCourseId(id);
		c.setCourseName(course.getCourseName());
		c.setCourseDesc(course.getCourseDesc());
		c.setCourseLogo(course.getCourseLogo());
		c.setCoursePrice(course.getCoursePrice());
		c.setNoOfVideo(course.getNoOfVideo());
		//fetch list of courses here and add it in category object , After that u can save 
		courseRepo.save(c); 	
		
	}
	@Override
	public void updateVideo(int id, Video video) {
		Video v=new Video();
		v=videoRepo.getOne(id);
		
		
		v.setVideoId(id);
		v.setVideoName(video.getVideoName());
		v.setVideoDesc(video.getVideoDesc());
		v.setVideoPath(video.getVideoPath());
		
		videoRepo.save(v); 
	}
	
	public Optional<Video> getVideo(int id){
		Optional<Video> video = videoRepo.findById(id);
		return video;
	}

	
	public void deleteVideo(int id) {
		videoRepo.deleteById(id);

	}

	public void addUser(User user, String type) {
		if (type.equalsIgnoreCase("prime")) {
			PrimeUser u = (PrimeUser) new PrimeUser().setEmail(user.getEmail()).setMobileNo(user.getMobileNo())
					.setStatus(user.getStatus()).setUsername(user.getUsername()).build();

			userRepo.save(u);
		} else {
			userRepo.save(user);
		}
	}

	@Override
	public List<User> getAllUser() {
		List<User> userList = userRepo.findAll();
		return userList;
	}

	@Override
	public User getUserById(int id) {
		User user = userRepo.findById(id).get();

		return user;
	}

	@Override
	public void addProfile(Profile profile, int id) {
		User user = userRepo.findById(id).get();
		profile.setUser(user).build();
		user.setProfile(profile);
		profileRepo.save(profile);

	}

	@Override
	public void updateUserType(int id) {
		Optional<User> u = userRepo.findById(id);
		User user = u.get();
		PrimeUser primeuser = (PrimeUser) new PrimeUser().setEmail(user.getEmail()).setMobileNo(user.getMobileNo())
				.setStatus(user.getStatus()).setUsername(user.getUsername()).setId(id).build();

		userRepo.save(primeuser);

	}

	@Override
	public void enrollUser(int userid, int courseid) {
		

		Course course = courseRepo.findById(courseid).get();
		List<Enrollment> enrollmentList = course.getEnrollment();
		enrollmentList.add(new Enrollment().setUser(userid).build());
		course.setEnrollment(enrollmentList);
		courseRepo.save(course);

		List<Video> videoList = course.getVideo();
		for (Video video : videoList) {
			List<Videostatus> videoStatus = video.getVideostatus();
			videoStatus.add(new Videostatus().setUserId(userid).build());
			video.setVideostatus(videoStatus);
			videoRepo.save(video);
		}		

	}
	
	@Transactional
	public void enrollAllUser(int userid) {
		List<Integer> courseIdList = cartRepo.getAllCart(userid);
		for(int courseid : courseIdList) {
			enrollUser(userid, courseid);
			removeFromCart(userid, courseid);
		}
	}
	
	

	
	public void addToCart(int userid, int courseid) {
		Course course = courseRepo.findById(courseid).get();
		List<Cart> cartList = course.getCart();
		cartList.add(new Cart().setUserId(userid).build());
		course.setCart(cartList);
		courseRepo.save(course);

	}

	@Override
	@Transactional
	public void removeFromCart(int userId, int courseId) {
		cartRepo.removeFromCart(userId, courseId);

	}

	
	public List<Course> setAvgRating(List<Course> courseList) {

		for (Course c : courseList) {
			float avgRating = 0;
			for (Feedback f : c.getFeedback()) {
				avgRating = avgRating + f.getRating();
			}
			int rating = (int) (avgRating / (c.getFeedback().size()));
			System.out.println("\n"+rating);
			c.setRating(rating);
		}
		return courseList;
	}
	
	@Override
	public List<Course> getPopularCourse() {
		List<Course> courseList = courseRepo.findAll();
		Map<Course, Integer> map = new HashMap<Course, Integer>();

		for (Course c : courseList) {
			float avgRating = 0;
			for (Feedback f : c.getFeedback()) {
				avgRating = avgRating + f.getRating();
			}
			int rating = (int) (avgRating / (c.getFeedback().size()));
			
			map.put(c, rating);
		}
//	
//		List<Course> course = new ArrayList<Course>();
//		Map<Course, Integer> sortedMap = map.entrySet().stream()
//				.sorted(Map.Entry.<Course, Integer>comparingByValue().reversed())
//				.collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
//		
//		
		Map<Course, Integer> sortedByCount = map.entrySet()
                .stream()
                .sorted((Map.Entry.<Course, Integer>comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		
		List<Course> courses = new ArrayList<Course>(sortedByCount.keySet());
		
		
//		List<Course> courses = setAvgRating(courseList);
//		courses.stream().sorted((c1,c2)->c1.getRating()-c2.getRating()).collect(Collectors.toList());
		
		return setAvgRating(courses).subList(0, 6);
	}

	public void addFeedback(Feedback feedback, int userid, int courseid) {
		Course course = courseRepo.findById(courseid).get();
		List<Feedback> feedBackList = course.getFeedback();
		feedBackList.add(feedback.setUserid(userid));
		course.setFeedback(feedBackList);
		courseRepo.save(course);

	}


	public  List<Course> getCourseByCat(int id) {
		List<Course> courses = courseRepo.getCourseByCategory(id);
		List<Course> courseList = new ArrayList<Course>();
		for(Course c : courseList) {
			courseList.add(new Course()
					.setCourseId(c.getCourseId())
					.setCourseLogo(c.getCourseLogo())
					.setRating(c.getRating())
					.setCourseName(c.getCourseName())
					.setCoursePrice(c.getCoursePrice())
					.build());
		}
		return setAvgRating(courseList);
	}

	@Override
	public void addCourseLike(int userid, int courseid) {
		 Optional<Likes> like = likesRepo.getLike(userid, courseid);
		 if(like.isEmpty()) {
			 Course course = courseRepo.findById(courseid).get();
			 List<Likes> courseLike = course.getLike();
			 courseLike.add(new Likes().setStatus("like").setUseId(userid).build());
			 course.setLike(courseLike);
			courseRepo.save(course) ;
		 }
		 else if(like.get().getStatus().equalsIgnoreCase("like")) {
			 like.get().setStatus("unlike");
			 likesRepo.save(like.get());	 
		 }
		 else if(like.get().getStatus().equalsIgnoreCase("unlike")) {
			 like.get().setStatus("like");
			 likesRepo.save(like.get());	 
		 }
		
	}

	@Override
	public Course getCourseByCourseId(int courseId) {
		Course course = courseRepo.findById(courseId).get();
		List<Course> c = new ArrayList<Course>();
		c.add(course);
		return setAvgRating(c).get(0);
	}
	@Override
	public  List<Course> getCourseByCatForDisplay(int id) {
		List<Course> courses = courseRepo.getCourseByCategory(id);
		return courses;
}
	public  List<Video> getVideoByCourseId(int id){
		List<Video> videos = videoRepo.getVideoByCourse(id);
		return videos;
	}
}
