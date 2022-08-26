package com.lms.api.dto;

import java.time.LocalDate;
import java.util.List;

import com.lms.api.model.Answer;

public class QueNewDto {

	private Long id;
	private String questionText;
	private String username;
	private LocalDate dateOfPost;
	private int numberOfAnswer;
	private List<Answer> list;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public LocalDate getDateOfPost() {
		return dateOfPost;
	}

	public void setDateOfPost(LocalDate dateOfPost) {
		this.dateOfPost = dateOfPost;
	}

	public int getNumberOfAnswer() {
		return numberOfAnswer;
	}

	public void setNumberOfAnswer(int numberOfAnswer) {
		this.numberOfAnswer = numberOfAnswer;
	}

	public List<Answer> getList() {
		return list;
	}

	public void setList(List<Answer> list) {
		this.list = list;
	}

}
