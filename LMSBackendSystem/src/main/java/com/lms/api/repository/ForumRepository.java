package com.lms.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.api.model.Forum;
import com.lms.api.model.Question;

public interface ForumRepository extends JpaRepository<Forum, Long>{

	

}
