package com.mov.moviepublish.mongo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MoviesDataRepository extends ReactiveMongoRepository<MoviesData, String>{
	
	public Mono<MoviesData> findById(String id);
	
	public Flux<MoviesData> findByMovieLanguage(String name);
	
	public Flux<MoviesData> findByMovieCertificate(String cretificate);
	
	public Mono<MoviesData> findByMovieName(String name);
	
	public Mono<MoviesData> findByIdAndMovieName(String id,String name);
}
