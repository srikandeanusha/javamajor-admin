package com.example.demo.dto;

public class DtoCourse {
	
	private String courseName;
	private String courseDesc;
	private String courseLogo;
	private int coursePrice;
	private int noOfVideo = 0;
	public DtoCourse(String courseName, String courseDesc, String courseLogo, int coursePrice, int noOfVideo) {
		super();
		this.courseName = courseName;
		this.courseDesc = courseDesc;
		this.courseLogo = courseLogo;
		this.coursePrice = coursePrice;
		this.noOfVideo = noOfVideo;
	}
	public DtoCourse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseDesc() {
		return courseDesc;
	}
	public void setCourseDesc(String courseDesc) {
		this.courseDesc = courseDesc;
	}
	public String getCourseLogo() {
		return courseLogo;
	}
	public void setCourseLogo(String courseLogo) {
		this.courseLogo = courseLogo;
	}
	public int getCoursePrice() {
		return coursePrice;
	}
	public void setCoursePrice(int coursePrice) {
		this.coursePrice = coursePrice;
	}
	public int getNoOfVideo() {
		return noOfVideo;
	}
	public void setNoOfVideo(int noOfVideo) {
		this.noOfVideo = noOfVideo;
	}
	@Override
	public String toString() {
		return "DtoCourse [courseName=" + courseName + ", courseDesc=" + courseDesc + ", courseLogo=" + courseLogo
				+ ", coursePrice=" + coursePrice + ", noOfVideo=" + noOfVideo + "]";
	}
	
}
