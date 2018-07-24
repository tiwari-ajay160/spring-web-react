package com.mov.moviepublish.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class MoviesData {

	@Id
	private String id;
	
	private String movieName;
	
	private String movieGenre;
	
	private Integer movieDuration;
	
	private String movieLanguage;
	
	private String movieCertificate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieGenre() {
		return movieGenre;
	}

	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}

	public Integer getMovieDuration() {
		return movieDuration;
	}

	public void setMovieDuration(Integer movieDuration) {
		this.movieDuration = movieDuration;
	}

	public String getMovieLanguage() {
		return movieLanguage;
	}

	public void setMovieLanguage(String movieLanguage) {
		this.movieLanguage = movieLanguage;
	}

	public String getMovieCertificate() {
		return movieCertificate;
	}

	public void setMovieCertificate(String movieCertificate) {
		this.movieCertificate = movieCertificate;
	}
}
