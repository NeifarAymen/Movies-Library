package com.spring.interview.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.spring.interview.Entity.Film;
import com.spring.interview.Repository.FilmRepository;
import com.spring.interview.Utils.RestPrecondition;

@Service
public class FilmServices {

	@Autowired
	private FilmRepository filmRepository;

	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	private static final String Entity_NAME="Film ";
	
	public List<Film> findAll() {
		return filmRepository.findAll();
	}
	
	public Film findOne(int id) {
		Film film = null;
		try {
		 film = filmRepository.findById(id).get();
		}catch (Exception e) {
			RestPrecondition.checkFound(film,Entity_NAME+"not Found");
		}
		return filmRepository.findById(id).get();
	}
	
		
	public ResponseEntity<Film> addFilm(Film film) throws URISyntaxException {
		film.setId(sequenceGeneratorService.getSequenceNumber(Film.SEQUENCE_NAME));
		Film res=filmRepository.save(film);
		return ResponseEntity.created(new URI("api/films/"+res.getId())).body(res);	
	}

	
	public ResponseEntity<Film> update(Film film) throws URISyntaxException {
		Film res =filmRepository.findById(film.getId()).get();
		if(res == null) {
			film.setId(sequenceGeneratorService.getSequenceNumber(Film.SEQUENCE_NAME));
			Film res2=filmRepository.save(film);
			return ResponseEntity.created(new URI("api/films/"+res2.getId())).body(res2);
		}
		else {
			res.setTitle(film.getTitle());
			res.setDirector(film.getDirector());
			res.setReleaseDate(film.getReleaseDate());
			res.setType(film.getType());
			res.setId(film.getId());
			filmRepository.save(res);
			return ResponseEntity.created(new URI("api/films/"+res.getId())).body(res);
		}
	}
	
	public ResponseEntity<Void> deleteFilm(@PathVariable int id){
		filmRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
