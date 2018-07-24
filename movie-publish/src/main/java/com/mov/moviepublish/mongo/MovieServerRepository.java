package com.mov.moviepublish.mongo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovieServerRepository extends ReactiveMongoRepository<MovieServers, String>{
	

	public Mono<MovieServers> findByServerName(String name);
}
