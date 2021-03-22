package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dao.CategoryRepository;
import com.example.demo.dao.CourseRepository;

import com.example.demo.dao.UserRepository;
import com.example.demo.dao.VideoRepository;
import com.example.demo.model.Category;
import com.example.demo.model.Course;
import com.example.demo.model.PrimeUser;
import com.example.demo.model.Profile;

import com.example.demo.model.User;
import com.example.demo.model.Video;

@SpringBootApplication
public class SpringMajorProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMajorProjectApplication.class, args);
	}
//hellooooooo
//	@Autowired
//	CategoryRepository car;
//	@Autowired
//	CourseRepository cor;
//	@Autowired
//	VideoRepository vor;
//
//	@Autowired
//	RegularUserRepository rur;
//	
//	@Autowired
//	UserRepository<PrimeUser> pur;
//	
//	@Autowired
//	UserRepository<User> ur;
//	

//	@Autowired
//	ProfileRepository pr;
	
	//@Override
	//public void run(String... args) throws Exception {

//		List<Video> vl1 = new ArrayList<Video>();
//		List<Video> vl2 = new ArrayList<Video>();
//		List<Course> course = new ArrayList<Course>();
//
//		Course c1 = new Course("java1", "best1", "logo1.jpg", 34578, vl1);
//		Course c2 = new Course("java2", "best2", "logo2.jpg", 34578, vl2);
//
//		course.add(c2);
//		course.add(c1);
//
//		Video v1 = new Video("video1", "videoDesc", "video1path");
//		Video v2 = new Video("video2", "video2Desc", "video2path");
//		Video v3 = new Video("video3", "video3Desc", "video3path");
//
//		vl1.add(v1);
//		vl1.add(v2);
//		vl2.add(v3);
		
		
//		
//		vl1 = vor.getVideoByCourse(4);
//		System.out.println(vl1.size());
//		for(Video v:vl1) {
//			System.out.println(v);
//		}
//		
//		
//		List<Course> course1 = cor.getCourseByCategory(1);
//		System.out.println(course1.size());
		
//		Category c = new Category("category1", "categorydesc", "categorylogo", course);
//			Category ca1= new Category();
//		 car.save(c);
//		 
		 
		//		Category cat = new Category("cat1", "cadesc1", "cadesc2", null);
		//		car.save(cat);

		//	Optional<Category> cat = car.findById(1);
			
		
		//		Course co = new Course("c1", "cd1", "cl1", 0, null);
		//		List<Course> C= new ArrayList<>();
		//		C.add(co);
		
		//		cat.get().setCourses(C);
		//		car.save(cat.get());
		
		//		Course co1 = new Course("c2","cd2","cl2",100,null);
		//		List<Course>C1 = cat.get().getCourses();
		//		C1.add(co1);
		//		cat.get().setCourses(C1);
		//		car.save(cat.get());

		//		co.setVideo(vL);
		//		cor.save(co);

//		Optional<Course> cours = cor.findById(2);
//		Video v4 = new Video("video4", "videoDesc", "video4path");
//		Video v5 = new Video("video4", "videoDesc", "video4path");
//		List<Video> vL = cours.get().getVideo();
//			vL.add(v4);
//			vL.add(v5);
//				cours.get().setVideo(vL);
//			cours.get().setNoOfVideo(vL.size());
//			
//				cor.save(cours.get());
		

	//	car.deleteById(1);
//		System.out.println(cor.getCourseByCategory(13));
//		
//	User ru= new RegularUser("reg1", "remail", 10, "unlocked");
	//ur.save(ru);
		
//		User u =ur.findById(2).get();
//		Profile p =new Profile(u,"GNR","BE", "Student");
//		u.setProfile(p);
//		ur.save(u);
		

	
		
//		
	//PrimeUser pu1= new PrimeUser("prime1", "primeemail", 100, "unlocked");
		//pur.save(pu1);
	
		
		
		
//		for(User u : rur.findAll()) {
//			System.out.println(u.getEmail());
//		}
//		
//System.out.println("-------------------------------------------------");
//		for(User u : ur.findAll()) {
//			System.out.println(u.getEmail());
//		}
		
//		RegularUser ru1 =  rur.findById(20).get();
//		
//		
//		ru1.setProfile(pf);
//		
//				pr.save(pf);
		
		
//	
	//}

}
