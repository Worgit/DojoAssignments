package com.ebergstein.overflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ebergstein.overflow.models.Answer;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long>{

	List<Answer> findByQuestionId(Long id);
	
}
