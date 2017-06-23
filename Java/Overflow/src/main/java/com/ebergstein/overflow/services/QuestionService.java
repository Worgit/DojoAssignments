package com.ebergstein.overflow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ebergstein.overflow.models.Question;
import com.ebergstein.overflow.repositories.QuestionRepository;

@Service
public class QuestionService {
	
	private QuestionRepository questionRepository;
	
	public QuestionService(QuestionRepository questionRepository){
		this.questionRepository = questionRepository;
	}
	
	public List<Question> findAllQuestions(){
		return (List<Question>) questionRepository.findAll();
	}
	
	public Question findQuestionById(Long id){
		return (Question) questionRepository.findOne(id);
	}
	
	public void addQuestion(Question question){
		questionRepository.save(question);
	}
	
	public Question findTopQuestion(){
		return (Question) questionRepository.findTop1ByOrderByIdDesc();
	}

}
