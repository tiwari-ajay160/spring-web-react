package com.mov.moviepublish.controller;

import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.server.RequestPredicate;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.mov.moviepublish.Beans.MovieScheduleBean;
import com.mov.moviepublish.Beans.MovieServerBean;
import com.mov.moviepublish.mongo.MovieSchedule;
import com.mov.moviepublish.mongo.MovieServers;
import com.mov.moviepublish.mongo.MoviesData;
import com.mov.moviepublish.service.MoviePublishService;
import com.mov.moviepublish.service.MovieScheduleService;

import reactor.core.publisher.Mono;


@Configuration
public class ControllerRoutes {
	
	@Autowired
	private MoviePublishService publishService;
	
	@Autowired
	private MovieScheduleService scheduleService;
	
	@Bean
	public RouterFunction<ServerResponse> routes(){
		return RouterFunctions
				.route(GET("/allMovies"), e -> ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM).body(publishService.findAllMovies(),MoviesData.class))
				.andRoute(GET("/movieId/{id}"), e -> ServerResponse.ok().body(publishService.findByIdService(e.pathVariable("id")),MoviesData.class))
				.andRoute(GET("/movieName/{name}"), e -> ServerResponse.ok().body(publishService.findByMovieNameService(e.pathVariable("name")),MoviesData.class))
				.andRoute(GET("/moviesCert/{certificate}"), e -> ServerResponse.ok().body(publishService.findByMovieCertificateService(e.pathVariable("certificate")),MoviesData.class))
				.andRoute(GET("/moviesLang/{language}"), e -> ServerResponse.ok().body(publishService.findByMovieLanguageService(e.pathVariable("language")),MoviesData.class))
				.andRoute(GET("/schedule/{id}/{name}"), e-> ServerResponse.ok().body(scheduleService.shedule(e.pathVariable("id"), e.pathVariable("name")), MovieSchedule.class))
				.andRoute(GET("/deleteSchedule/{id}"), e-> ServerResponse.ok().body(scheduleService.deleteSchedule(e.pathVariable("id")),MovieSchedule.class))
				.andRoute(GET("/allSchedules"), e->ServerResponse.ok().body(scheduleService.getAllSchedule(), MovieSchedule.class))
				.andRoute(GET("/streamingLive"), e->ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM).body(scheduleService.currentlyStreaming(), MovieScheduleBean.class))
				.andRoute(GET("/allServer"), e->ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM).body(scheduleService.findAllServer(), MovieServerBean.class))
				.andRoute(GET("/resetAllSchedules"), e->ServerResponse.ok().body(scheduleService.resetAllSchedule(),Object.class));
	}
	
	

}
