package com.mov.moviepublish.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mov.moviepublish.mongo.MovieServers;
import com.mov.moviepublish.mongo.MoviesData;
import com.mov.moviepublish.service.MoviePublishService;
import com.mov.moviepublish.service.MovieScheduleService;

import reactor.core.publisher.Flux;

@RestController
public class Controller {
	
	@Autowired
	private MoviePublishService publishService;
	
	@Autowired
	private MovieScheduleService scheduleService;
	
	@PostMapping(value="/saveMovies")
	public Flux<MoviesData> saveAllMovies(@RequestBody List<MoviesData> moviesList){
		return publishService.saveAllMovies(moviesList);
	}
	
	@GetMapping(value="/getbyLang/{lang}",produces=MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<MoviesData> getMovies(@PathVariable(value="lang") String lang){
		return publishService.findByMovieLanguageService(lang);
	}
	
	@PostMapping(value="/saveServer")
	public Flux<MovieServers> saveServers(@RequestBody List<MovieServers> server){
		return scheduleService.saveServers(server);
	}

}
