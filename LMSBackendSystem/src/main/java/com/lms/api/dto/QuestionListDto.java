package com.lms.api.dto;

public class QuestionListDto {
	
	
	private Long id;
	private String text;
	private long likes;
	private String username;
	private int numberOfAnswers;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public long getLikes() {
		return likes;
	}
	public void setLikes(long likes) {
		this.likes = likes;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getNumberOfAnswers() {
		return numberOfAnswers;
	}
	public void setNumberOfAnswers(int numberOfAnswers) {
		this.numberOfAnswers = numberOfAnswers;
	}
	
	
	
	@Override
	public String toString() {
		return "QuestionListDto [id=" + id + ", text=" + text + ", likes=" + likes + ", username=" + username
				+ ", numberOfAnswers=" + numberOfAnswers + "]";
	}

}
