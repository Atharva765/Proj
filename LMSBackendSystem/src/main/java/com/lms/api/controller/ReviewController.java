package com.lms.api.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lms.api.dto.ReviewAllDTO;
import com.lms.api.dto.ReviewDto;

import com.lms.api.model.Course;
import com.lms.api.model.Review;
import com.lms.api.model.User;
import com.lms.api.repository.CourseRepository;
import com.lms.api.repository.ReviewRepository;
import com.lms.api.repository.UserRepository;

@RestController
public class ReviewController {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private ReviewRepository reviewRepository;
	
	@PostMapping("/review/{cid}")
	public Review addReview(@PathVariable("cid")Long cid,
						 @RequestBody Review review, Principal principal) {
		
		Course course = courseRepository.getById(cid);
		User user =  userRepository.getByUsername(principal.getName());
		
		if(course != null)
			review.setCourse(course);
		review.setUser(user);
		return reviewRepository.save(review);
		
	}
	
	@GetMapping("/review/{cid}")
	public List<Review> getReviewByCourseId(@PathVariable("cid") Long cid){
		
		List<Review> reviewList=reviewRepository.getByCourseId(cid);
		
		/*List<ReviewAllDTO> reviewAllDTOList = new ArrayList<>();
		
		reviewList.stream().forEach(r->{
					ReviewAllDTO reviewAllDTO = new ReviewAllDTO();
								reviewAllDTO.setId(r.getId());
								reviewAllDTO.setContent(r.getContent());
								reviewAllDTO.setRating(r.getRating());
								reviewAllDTO.setUserId(r.getUser().getId());
								reviewAllDTO.setName(r.getUser().getName());
								reviewAllDTO.setUsername(r.getUser().getUsername());
								reviewAllDTO.setEmail(r.getUser().getEmail());
								reviewAllDTO.setCourseId(r.getCourse().getId());
								reviewAllDTO.setCourseName(r.getCourse().getName());
								reviewAllDTO.setLearningTrackId(r.getCourse().getLearningTrack().getId());
								reviewAllDTO.setLearningTrack(r.getCourse().getLearningTrack().getName());
					reviewAllDTOList.add(reviewAllDTO);
		});
		
		return reviewAllDTOList;*/
		return reviewList;
	}
	
	@GetMapping("/review-all-info/{cid}")
	public List<ReviewAllDTO> getReviewAllInfoByCourseId(@PathVariable("cid") Long cid){
		
		List<Review> reviewList=reviewRepository.getByCourseId(cid);
		
	List<ReviewAllDTO> reviewAllDTOList = new ArrayList<>();
		
		reviewList.stream().forEach(r->{
					ReviewAllDTO reviewAllDTO = new ReviewAllDTO();
								reviewAllDTO.setId(r.getId());
								reviewAllDTO.setContent(r.getContent());
								reviewAllDTO.setRating(r.getRating());
								reviewAllDTO.setUserId(r.getUser().getId());
								reviewAllDTO.setName(r.getUser().getName());
								reviewAllDTO.setUsername(r.getUser().getUsername());
								reviewAllDTO.setEmail(r.getUser().getEmail());
								reviewAllDTO.setCourseId(r.getCourse().getId());
								reviewAllDTO.setCourseName(r.getCourse().getName());
								reviewAllDTO.setLearningTrackId(r.getCourse().getLearningTrack().getId());
								reviewAllDTO.setLearningTrack(r.getCourse().getLearningTrack().getName());
					reviewAllDTOList.add(reviewAllDTO);
		});
		
		return reviewAllDTOList;
		
	}

	
	@GetMapping("/reviews")
	public List<Review> getAllReviews(){
		
		return reviewRepository.findAll();
	}
	
	@GetMapping("/reviewsorted/{cid}")
	public List<Review> getReviewByCourseIdSortByRatingDESC(@PathVariable("cid")Long cid) {
		List<Review> reviewList = reviewRepository.getByCourseId(cid);
		 reviewList = reviewList.stream().sorted(new B()).collect(Collectors.toList());
		
		
		return reviewList;
		
	}
	
	@PutMapping("/review/{rid}")
	public Review getByCourseId(Principal principal ,@PathVariable("rid") Long rid,
							@RequestBody Review review) {
		
		String username = principal.getName();
	
		Review reviewDb = reviewRepository.getById(rid);
		if(review.getContent()!=null)
			reviewDb.setContent(review.getContent());
		if(review.getRating() != 0)
			reviewDb.setRating(review.getRating());
		
		String userOwner = reviewDb.getUser().getUsername();
		
		if(! username.equalsIgnoreCase(userOwner) )
			throw new RuntimeException("User not allowed to edit the review");
		
		return reviewRepository.save(reviewDb);
	}
	
	@GetMapping("/reviewstats/{cid}")
	public ReviewDto getReviewStatsByCourseId(@PathVariable("cid") Long cid) {
		
		List<Review> list = reviewRepository.getByCourseId(cid);
		
		ReviewDto dto = new ReviewDto();
		dto = dto.convert(list);
		
		return dto;
		
	}
	
	
}

class B implements Comparator<Review>{

	@Override
	public int compare(Review r1, Review r2) {
		
		return (int)( r2.getRating()-r1.getRating()  );
	}
	
}
