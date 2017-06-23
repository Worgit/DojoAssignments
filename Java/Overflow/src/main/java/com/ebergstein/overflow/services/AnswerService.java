package com.ebergstein.overflow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ebergstein.overflow.models.Answer;
import com.ebergstein.overflow.repositories.AnswerRepository;

@Service
public class AnswerService {

	private AnswerRepository answerRepository;
	
	public AnswerService(AnswerRepository answerRepository){
		this.answerRepository = answerRepository;
	}
	
	public List<Answer> findOneByQuestionId(Long id){
		return (List<Answer>) answerRepository.findByQuestionId(id);
	}
	
	public void addAnswer(Answer answer){
		answerRepository.save(answer);
	}
	
}
