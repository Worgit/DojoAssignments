package com.ebergstein.overflow.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ebergstein.overflow.models.Question;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long>{
	Question findTop1ByOrderByIdDesc();
}
