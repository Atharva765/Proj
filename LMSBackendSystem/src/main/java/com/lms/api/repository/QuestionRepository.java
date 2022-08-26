package com.lms.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lms.api.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Long>{
	
	
	
	@Query("select q from Question q where q.forum.id=?1")
	List<Question> getAllQuestion(Long fid);

	

	

	

}
