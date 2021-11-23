package com.spring.interview.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.interview.Entity.Film;

public interface FilmRepository extends MongoRepository<Film, Integer>{

	Film findByTitle(String title);
	
}
