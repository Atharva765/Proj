package com.lms.api.dto;

import java.time.Duration;
import java.util.List;

import com.lms.api.model.Video;

public class ModuleDto {

	private Long id;
	private String name;
	private int sequence;
	private List<Video> video;

	public static class ModuleStatsDto {

		
		private long numModule;
		private long numVideo;
		private String contentDuration;

		

		public long getNumModule() {
			return numModule;
		}

		public void setNumModule(long numModule) {
			this.numModule = numModule;
		}

		public long getNumVideo() {
			return numVideo;
		}

		public void setNumVideo(long numVideo) {
			this.numVideo = numVideo;
		}

		public String getContentDuration() {
			return contentDuration;
		}

		public void setContentDuration(String contentDuration) {
			this.contentDuration = contentDuration;
		}

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public List<Video> getVideo() {
		return video;
	}

	public void setVideo(List<Video> video) {
		this.video = video;
	}

}
