package com.lms.api.dto;

import java.util.List;

public class ForumDto {
	
	private Long forumId;
	private String topic;
	private List<QuestionListDto> list;
	
	public static class ForumStatDto{
		
		private int numTopic;
		private int numQuestion;
		private int numAnswer;
		private int numUsers;
		
		public int getNumTopic() {
			return numTopic;
		}
		public void setNumTopic(int numTopic) {
			this.numTopic = numTopic;
		}
		public int getNumQuestion() {
			return numQuestion;
		}
		public void setNumQuestion(int numQuestion) {
			this.numQuestion = numQuestion;
		}
		public int getNumAnswer() {
			return numAnswer;
		}
		public void setNumAnswer(int numAnswer) {
			this.numAnswer = numAnswer;
		}
		public int getNumUsers() {
			return numUsers;
		}
		public void setNumUsers(int numUsers) {
			this.numUsers = numUsers;
		}
		
		
	}

	public Long getForumId() {
		return forumId;
	}

	public void setForumId(Long forumId) {
		this.forumId = forumId;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public List<QuestionListDto> getList() {
		return list;
	}

	public void setList(List<QuestionListDto> list) {
		this.list = list;
	}

}
