package com.spring.interview.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "film")
public class Film {

	@Transient
	public static final String SEQUENCE_NAME = "film_sequence";

	@Id
	private int id;

	private String title;

	private String director;

	private String releaseDate;

	private String type;

	public Film() {
		super();
	}

	public Film(int id, String title, String director, String releaseDate, String type) {
		super();
		this.id = id;
		this.title = title;
		this.director = director;
		this.releaseDate = releaseDate;
		this.type = type;
	}

	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
