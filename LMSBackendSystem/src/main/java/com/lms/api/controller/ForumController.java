package com.lms.api.controller;

import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lms.api.model.Answer;
import com.lms.api.model.Author;
import com.lms.api.model.Course;
import com.lms.api.model.Forum;
import com.lms.api.model.Question;
import com.lms.api.model.User;
import com.lms.api.repository.AnswerRepository;
import com.lms.api.repository.ForumRepository;
import com.lms.api.repository.QuestionRepository;
import com.lms.api.repository.UserRepository;

@RestController
public class ForumController {
	
	@Autowired
	private ForumRepository forumRepository;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AnswerRepository answerRepository;
	
	@PostMapping("/forum")
	public Forum addForum(@RequestBody Forum forum) {
		return forumRepository.save(forum);
	}
	
	
	
	@PostMapping("/question/{fid}")
	public Question addQuestion(@RequestBody Question question, Principal principal
						,@PathVariable("fid") Long fid) {
		
		question.setForum(forumRepository.getById(fid)) ;
		
		User user = userRepository.getByUsername(principal.getName());
		
		question.setUsername(user.getUsername());
		
		question.setDateOfPost(LocalDate.now());
		
		return questionRepository.save(question);
	}
	
	@GetMapping("/question")
	public List<Question> getAllQuestion(){
		List<Question> list = questionRepository.findAll();
		return list;
	}
	
	@PostMapping("/answer")
	public Answer addAnswer(@RequestBody Answer answer, Principal principal) {
		
		User user = userRepository.getByUsername(principal.getName());
		
		answer.setUsername(user.getUsername());
		
		answer.setDateOfPost(LocalDate.now().plusDays(2));
		
		return answerRepository.save(answer);
	}
	
	@GetMapping("/answer")
	public List<Answer> getAllAnswer(){
		List<Answer> list = answerRepository.findAll();
		return list;
	}
	
//	@PostMapping("/forum/question/{fid}/{qid}")
//	public Question assignforumtoQuestion(@PathVariable("fid")Long fid, @PathVariable("qid")Long qid) {
//		
//		Forum forum = forumRepository.getById(fid);
//		Question question = questionRepository.getById(qid);
//		
//		question.se(forum.getId());
//		
//		return questionRepository.save(question);
//	}
	
	
	@GetMapping("/forum/{fid}")
	public List<String> getUsername(@PathVariable("fid") Long fid) {
		
		return  questionRepository.getAllQuestion(fid).stream().map(m->m.getUsername())
						.distinct().collect(Collectors.toList());
		
		
		
		
	}
	
	
}
