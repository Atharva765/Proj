package com.lms.api.dto;

import java.util.ArrayList;
import java.util.List;

import com.lms.api.model.Review;

public class ReviewAllDTO {
	
	private long id;
	private String content;
	private double rating;
	private long userId;
	private String Username;
	private String name;
	private String email;
	private long courseId;
	private String courseName;
	private long learningTrackId;
	private String learningTrack;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getCourseId() {
		return courseId;
	}
	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public long getLearningTrackId() {
		return learningTrackId;
	}
	public void setLearningTrackId(long learningTrackId) {
		this.learningTrackId = learningTrackId;
	}
	public String getLearningTrack() {
		return learningTrack;
	}
	public void setLearningTrack(String learningTrack) {
		this.learningTrack = learningTrack;
	}
	
	
	
	
}
