package com.lms.api.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
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
public class ModuleController {
	
	@Autowired
	private ModuleRepository moduleRepository;
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private VideoRepository videoRepository;
	
	@PostMapping("/module/{cid}")
	public Module addModule(@PathVariable("cid")Long cid, @RequestBody Module module) {
		
		Course course = courseRepository.getById(cid);
		module.setCourse(course);
		return moduleRepository.save(module);
	}
	
	@GetMapping("/module/{cid}")
	public List<ModuleDto> getAllModuleByCourseId(@PathVariable("cid")Long cid) {
		
		List<Module> list = moduleRepository.findByCourseId(cid);
		List<ModuleDto> listDto = new ArrayList<>();
		list.stream().forEach(m->{
			ModuleDto dto = new ModuleDto();
			List<Video> listVideo = videoRepository.findByModuleId(m.getId());
			dto.setId(m.getId());
			dto.setName(m.getName());
			dto.setSequence(m.getSequence());
			dto.setVideo(listVideo);
			listDto.add(dto);
		});
		
		return listDto;
	}
	
	/*
	 * Use Alternate method to increase the performance as 
	 * in above method we used for loop to executed query to findByModuleId n times
	 * in below method we executed query only once and then used for loop.
	 * therefore, to reduce the execution of query we use alternate method 
	 */
	
	@GetMapping("/module/alternate/{cid}")
	public List<ModuleDto> getAllModuleByCourseIdAlternate(@PathVariable("cid")Long cid) {
		
		//Fetch all modules based on courseId
		List<Module> list = moduleRepository.findByCourseId(cid);
		List<ModuleDto> listDto = new ArrayList<>();
		
		//fetch all videos for given courseId
		List<Video> listVdo = videoRepository.getByCourseId(cid);
		
		//Iterate through each module to fetch list of videos for that module
		list.stream().forEach(m->{
			ModuleDto dto = new ModuleDto();
			
			// fetch videos for each moduleId
			
			List<Video> listVideo = listVdo.parallelStream()
									.filter(v->v.getModule().getId().equals(m.getId()))
									.collect(Collectors.toList());
		
			dto.setId(m.getId());
			dto.setName(m.getName());
			dto.setSequence(m.getSequence());
			dto.setVideo(listVideo);
			listDto.add(dto);
		});
		
		return listDto;
	}
	
	
	
}
