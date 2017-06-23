package com.ebergstein.language.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ebergstein.language.models.Language;


@Repository
public interface LanguageRepository extends CrudRepository<Language, Long>{
}
