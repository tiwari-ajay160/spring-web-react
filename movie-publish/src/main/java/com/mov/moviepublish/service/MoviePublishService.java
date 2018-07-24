package com.mov.moviepublish.service;

import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mov.moviepublish.mongo.MovieSchedule;
import com.mov.moviepublish.mongo.MovieScheduleRepository;
import com.mov.moviepublish.mongo.MoviesData;
import com.mov.moviepublish.mongo.MoviesDataRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MoviePublishService {
	
	@Autowired
	private MoviesDataRepository movieDataRepo;
	

	
	public Mono<MoviesData> findByIdService(String id){
		return movieDataRepo.findById(id);
	}
	
	public Flux<MoviesData> findByMovieLanguageService(String name){
		return movieDataRepo.findByMovieLanguage(name).delayElements(Duration.ofSeconds(1));
	}
	
	public Flux<MoviesData> findByMovieCertificateService(String cretificate){
		return movieDataRepo.findByMovieCertificate(cretificate).delayElements(Duration.ofSeconds(1));
	}
	
	public Mono<MoviesData> findByMovieNameService(String name){
		return movieDataRepo.findByMovieName(name);
	}
	
	public Flux<MoviesData> findAllMovies(){
		return movieDataRepo.findAll().delayElements(Duration.ofSeconds(1));
	}
	
	public Flux<MoviesData> saveAllMovies(List<MoviesData> moviesList){
		return movieDataRepo.saveAll(moviesList);
	}
	
	

}
