package com.lms.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lms.api.dto.ModuleDto;
import com.lms.api.model.Course;
import com.lms.api.model.Module;
import com.lms.api.model.Video;
import com.lms.api.repository.CourseRepository;
import com.lms.api.repository.ModuleRepository;
import com.lms.api.repository.VideoRepository;

@RestController
public class VideoController {
	
	@Autowired
	private VideoRepository videoRepository;
	
	@Autowired
	private ModuleRepository moduleRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@PostMapping("/video/{mid}")
	public Video addVideo(@PathVariable("mid") Long mid, @RequestBody Video video) {
		Module module = moduleRepository.getById(mid);
		video.setModule(module);
		return videoRepository.save(video);
	}
	
	/*
	 * {
	 *  numModules: 
	 *  numVideos:
	 *  contentDuration:<display in hours and minutes>
	 *  }
	 */
	@GetMapping("/course/video/stats/{cid}")
	public ModuleDto.ModuleStatsDto courseStatsByVideo(@PathVariable("cid") Long cid) {
		
		List<Video> list = videoRepository.getByCourseId(cid);
		
		List<Module> listm  = moduleRepository.getByCourseId(cid);
		
		ModuleDto.ModuleStatsDto mdto = new ModuleDto.ModuleStatsDto(); 
		
		mdto.setNumModule(listm.size()); 
		mdto.setNumVideo(list.size());
		
		return mdto;
	
	}
	
}
