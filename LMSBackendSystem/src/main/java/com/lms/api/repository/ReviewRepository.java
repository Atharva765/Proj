package com.lms.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.api.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>{

	List<Review> getByCourseId(Long cid);

}
