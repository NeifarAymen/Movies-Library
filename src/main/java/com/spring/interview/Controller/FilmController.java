package com.spring.interview.Controller;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.interview.Entity.Film;
import com.spring.interview.Repository.FilmRepository;
import com.spring.interview.Service.FilmServices;

@RestController
@RequestMapping("/api/films")
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
public class FilmController  {
	 
	@Autowired
	private FilmServices filmServices;
	
	@GetMapping
	public List<Film> findAll(){	
		return filmServices.findAll();
	}
	
	@GetMapping("/{id}")
	public Film findOne(@PathVariable int id){	
		return filmServices.findOne(id);
	}

	@PostMapping
	public ResponseEntity<Film> addFilm(@RequestBody Film film) throws URISyntaxException{
		return filmServices.addFilm(film);
	}
	
	@PutMapping
	public ResponseEntity<Film> updateFilm(@RequestBody Film film) throws URISyntaxException{
		return filmServices.update(film);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> DeleteFilm(@PathVariable int id) {
		return filmServices.deleteFilm(id);
	}
	
}
