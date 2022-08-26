package com.lms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lms.api.model.Author;
import com.lms.api.model.Course;
import com.lms.api.model.LearningTrack;
import com.lms.api.repository.AuthorRepository;
import com.lms.api.repository.CourseRepository;
import com.lms.api.repository.LearningTrackRepository;


@RestController
public class CourseController {
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private LearningTrackRepository learningTrackRepository;
	
	@PostMapping("/course/{ltid}")
	public Course addCourse(@RequestBody Course course,@PathVariable("ltid") Long ltid) {
		LearningTrack learningTrack = learningTrackRepository.getById(ltid);
		
		if(learningTrack != null)
			course.setLearningTrack(learningTrack);
		
		return courseRepository.save(course);
	}
	
	
	@GetMapping("/course")
	public List<Course> getCourse(){
		List<Course> list = courseRepository.findAll();
		return list;
	}
	
	@PostMapping("/course/author/{cid}/{aid}")
	public Course assignCoursetoAuthor(@PathVariable("cid") Long cid, @PathVariable("aid")Long aid) {
		
		Course course = courseRepository.getById(cid);
		List<Author> listAuthor = course.getAuthor();
		
		Author author = authorRepository.getById(aid);
		listAuthor.add(author);
		
		course.setAuthor(listAuthor);
		
		return courseRepository.save(course);
		
		
	}
	
	@DeleteMapping("/course/author/{cid}/{aid}")
	public Course deleteCourseAuthor(@PathVariable("cid")Long cid, @PathVariable("aid") Long aid) {
		
		Course course = courseRepository.getById(cid);
		List<Author> listAuthor = course.getAuthor();
		
		Author author = authorRepository.getById(aid);
		listAuthor.remove(author);
		
		course.setAuthor(listAuthor);
		
		return courseRepository.save(course);
		
		
	}
}
