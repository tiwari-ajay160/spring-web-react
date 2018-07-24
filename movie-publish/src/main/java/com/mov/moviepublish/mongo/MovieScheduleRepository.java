package com.mov.moviepublish.mongo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Mono;

public interface MovieScheduleRepository extends ReactiveMongoRepository<MovieSchedule, String>{

	
	public Mono<MovieSchedule> findByMovieId(String id);
	
	
	public Mono<MovieSchedule> deleteByMovieId(String id);
	
 }
