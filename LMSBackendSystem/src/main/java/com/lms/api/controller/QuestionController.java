package com.lms.api.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lms.api.dto.ForumDto;
import com.lms.api.dto.ForumDto.ForumStatDto;
import com.lms.api.dto.QueNewDto;
import com.lms.api.dto.QuestionDto;

import com.lms.api.dto.QuestionListDto;
import com.lms.api.model.Answer;
import com.lms.api.model.Forum;
import com.lms.api.model.Question;
import com.lms.api.model.Review;
import com.lms.api.model.User;
import com.lms.api.repository.AnswerRepository;
import com.lms.api.repository.ForumRepository;
import com.lms.api.repository.QuestionRepository;
import com.lms.api.repository.UserRepository;


@RestController
public class QuestionController {
	
	@Autowired
	private ForumRepository forumRepository;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AnswerRepository answerRepository;
	
	
	@PostMapping("/question/answer/{qid}/{aid}")
	public Question assignQuestiontoAnswer(@PathVariable("qid") Long qid, @PathVariable("aid") Long aid) {
		
		/*
		 * Fetch question
		 * fetch list of answer
		 * fetch answer
		 * add answer to list
		 * set list
		 * save question
		 */
		
		Question question = questionRepository.getById(qid);
		
		List<Answer> answerList = question.getAnswer();
		
		Answer answer = answerRepository.getById(aid);
		answerList.add(answer);
		question.setAnswer(answerList);
		
		return questionRepository.save(question);
	}
	
	@PostMapping("/answer/{qid}")
	public Question addAnswertoQuestion(@PathVariable("qid")Long qid, @RequestBody Answer answer) {
		
		Question quesDb = questionRepository.getById(qid);
		List<Answer> alist = quesDb.getAnswer();
		
		if(answer != null)
			alist.add(answer);
		
		quesDb.setAnswer(alist);
		
		return questionRepository.save(quesDb);
	}
	
	@GetMapping("/forum")
	public List<QuestionDto> getAllForum(
			@RequestParam(name = "page",required = false,defaultValue = "0")Integer page,
			@RequestParam(name = "size",required = false,defaultValue = "2")Integer size
			){
		
		Pageable pageable = PageRequest.of(page, size);
		
		
		List<Forum> list = forumRepository.findAll(pageable).getContent();
		List<Question> listQues = new ArrayList<>();
		List<QuestionDto> l = new ArrayList<>();
		
		for(Forum f : list) {
			QuestionDto dto = new QuestionDto();
			dto.setId(f.getId());
			dto.setTopic(f.getTopic());
			listQues = questionRepository.getAllQuestion(f.getId());
			dto.setNoOfQestions(listQues.size());
			dto.setList(listQues);
			l.add(dto);
		}
	
		return l;
	}
	
	@GetMapping("/question/{fid}")
	public ForumDto getQuestionByForumId(@PathVariable("fid") Long fid) {
		
		Forum forum = forumRepository.getById(fid);
		
		List<Question> list = questionRepository.getAllQuestion(fid);
		//QuestionListDto dt = new QuestionListDto(); //only one object was created
		
		List<QuestionListDto> dtList = new ArrayList<>();
		ForumDto d = new ForumDto();
		
		for(Question q : list) { 
			
			QuestionListDto  dt = new QuestionListDto(); // three objects
			
			dt.setId(q.getId());
			dt.setText(q.getQuestionText());
			dt.setUsername(q.getUsername());
			dt.setLikes(q.getLikes());
			dt.setNumberOfAnswers(q.getAnswer().size());
			dtList.add(dt);
		}
		
		d.setForumId(forum.getId());
		d.setTopic(forum.getTopic());
		d.setList(dtList);
		
		return d;
		
	}
	
	@GetMapping("/answer/{qid}")
    public QueNewDto getAnswerByQueId(@PathVariable ("qid") Long qid) {

		Question question = questionRepository.getById(qid);

		List<Answer> list = answerRepository.findByQuestionId(qid);
		
		List<Answer> sortedlist = list.stream().sorted(Comparator.comparing(Answer::getDateOfPost)
												.reversed())
												.collect(Collectors.toList());

		QueNewDto qdto = new QueNewDto();

		qdto.setId(question.getId());
		qdto.setQuestionText(question.getQuestionText());
		qdto.setUsername(question.getUsername());
		qdto.setDateOfPost(question.getDateOfPost());
		qdto.setNumberOfAnswer(question.getAnswer().size());
		qdto.setList(sortedlist);

		return qdto;   

 
    }
	
	
	
	@PutMapping("/answer/updatelike/{aid}")
	public Answer updateAnswerLike(@PathVariable("aid") Long aid) {
			
		Answer answerDb = answerRepository.getById(aid);
		
		answerDb.setLikes(answerDb.getLikes()+1);
		
		return answerRepository.save(answerDb);
		
	}
	
	@PutMapping("/question/updatelike/{qid}")
	public Question updateQuestionLike(@PathVariable("qid") Long qid) {
			
		Question questionDb = questionRepository.getById(qid);
		
		questionDb.setLikes(questionDb.getLikes()+1);
		
		return questionRepository.save(questionDb);
		
	}
	
	@PutMapping("/answer/{aid}")
	public Answer updateAnswer(@PathVariable("aid") Long aid,
						@RequestBody Answer answer,Principal principal) {
			
		Answer answerDb = answerRepository.getById(aid);
		
		if(answer.getAnswerText()!=null)
			answerDb.setAnswerText(answer.getAnswerText());
		if( !  principal.getName().equalsIgnoreCase(answerDb.getUsername())   )
			throw new RuntimeException("User not Allowed!");
		
		return answerRepository.save(answerDb);
		
	}
	
	@PutMapping("/question/{qid}")
	public Question updateQuestion(@PathVariable("qid") Long qid,
						@RequestBody Question question,Principal principal) {
			
		Question questionDb = questionRepository.getById(qid);
		
		if(question.getQuestionText()!=null)
			questionDb.setQuestionText(question.getQuestionText());
		
		if( !  principal.getName().equalsIgnoreCase(questionDb.getUsername())   )
			throw new RuntimeException("User not Allowed!");
		
		return questionRepository.save(questionDb);
		
	}
	
	@GetMapping("/forum/stats")
	public ForumStatDto forumStats() {
		
		List<Forum> list = forumRepository.findAll();
		List<Question> qlist= questionRepository.findAll();
		List<Answer> alist = answerRepository.findAll();
		
		Set<String> sl = new HashSet<>();
		
		
		alist.parallelStream().forEach(a->{
			sl.add(a.getUsername());
		});
		qlist.stream().forEach(q->{
			sl.add(q.getUsername());
		});
		
		
		ForumStatDto f = new ForumStatDto();
		
		f.setNumTopic(list.size());
		f.setNumQuestion(qlist.size());
		f.setNumAnswer(alist.size());
		f.setNumUsers(sl.size());
		
		return f;
		
	}
	
	
	

}
