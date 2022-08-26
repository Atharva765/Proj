package com.lms.api.controller;

import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lms.api.dto.LearningTrackDto;
import com.lms.api.model.Course;
import com.lms.api.model.Enroll;
import com.lms.api.model.LearningTrack;
import com.lms.api.model.User;
import com.lms.api.repository.CourseRepository;
import com.lms.api.repository.EnrollRepository;
import com.lms.api.repository.LearningTrackRepository;
import com.lms.api.repository.UserRepository;

@RestController
public class EnrollController {
	
	@Autowired
	private EnrollRepository enrollRepository;
	@Autowired
	private LearningTrackRepository learningTrackRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CourseRepository courseRepository;
	
	@PostMapping("/enroll/user/learning_track/{uid}/{lid}")
	public Enroll addEnroll(@PathVariable("uid") Long uid , @PathVariable("lid") Long lid ) {
		
		User user = userRepository.getById(uid);
		LearningTrack learningTrack = learningTrackRepository.getById(lid);
		
		Enroll enroll = new Enroll();
		
		if(user != null)
			enroll.setUser(user);
		if(learningTrack != null)
			enroll.setLearningTrack(learningTrack);
		
		enroll.setEnrollDate(LocalDate.now());
		enroll.setEndDate(LocalDate.now().plusYears(1));
		
		return enrollRepository.save(enroll);
		
	}
	
	
	@GetMapping("/user/learningtrack")
	public List<LearningTrackDto> getLearningTrackOnUser(Principal principal) {
		
		 List<LearningTrack> list = enrollRepository.getLearningTrackByUserId(principal.getName());
		 List<LearningTrackDto> listDto = new ArrayList<>();
			
			list.stream().forEach(lt-> {
				LearningTrackDto dto = new LearningTrackDto();
				List<Course> listCourse = courseRepository.findByLearningTrackId(lt.getId());
				dto.setId(lt.getId());
				dto.setName(lt.getName());
				dto.setCourse(listCourse);
				listDto.add(dto);
			});
			
			return listDto;
		
	}
}
