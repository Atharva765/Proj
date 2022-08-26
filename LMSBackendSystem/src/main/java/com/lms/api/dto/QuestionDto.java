package com.lms.api.dto;

import java.util.List;

import com.lms.api.model.Forum;
import com.lms.api.model.Question;

public class QuestionDto {

	private long id;
	private String topic;
	private long noOfQestions;
	private List<Question> list;
		
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public long getNoOfQestions() {
		return noOfQestions;
	}

	public void setNoOfQestions(long noOfQestions) {
		this.noOfQestions = noOfQestions;
	}

	public List<Question> getList() {
		return list;
	}

	public void setList(List<Question> list) {
		this.list = list;
	}

}
