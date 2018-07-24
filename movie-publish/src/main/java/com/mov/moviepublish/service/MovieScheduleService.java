package com.mov.moviepublish.service;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mov.moviepublish.Beans.MovieScheduleBean;
import com.mov.moviepublish.Beans.MovieServerBean;
import com.mov.moviepublish.mongo.MovieSchedule;
import com.mov.moviepublish.mongo.MovieScheduleRepository;
import com.mov.moviepublish.mongo.MovieServerRepository;
import com.mov.moviepublish.mongo.MovieServers;
import com.mov.moviepublish.mongo.MoviesData;
import com.mov.moviepublish.mongo.MoviesDataRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MovieScheduleService {
	

	@Autowired
	private MovieScheduleRepository scheduleRepo;
	
	@Autowired
	private MoviesDataRepository movieDataRepo;
	
	@Autowired
	private MovieServerRepository movieServerRepo;
	
	public Mono<MovieSchedule> shedule(String id,String name){	
		return movieDataRepo.findByIdAndMovieName(id, name).flatMap(e-> {
				return movieServerRepo.findAll(Sort.by(Direction.ASC, "lastMovieEndTime")).elementAt(0).flatMap(s-> {
					if(s.getLastMovieEndTime().before(new Date())){
						s.setLastMovieEndTime(new Date());
					}
					MovieSchedule schedule=new MovieSchedule();
					schedule.setServer(s.getServerName());
					schedule.setMovieId(e.getId());
					schedule.setMovieName(e.getMovieName());
					schedule.setRuntime(e.getMovieDuration());
					schedule.setSheduleDate(s.getLastMovieEndTime());
					s.setLastMovieEndTime(new Date(s.getLastMovieEndTime().getTime() + (e.getMovieDuration()*60000)));
					schedule.setScheduleEnd(s.getLastMovieEndTime());
					MovieScheduleBean bean=new MovieScheduleBean();
					if(s.getServerSchedule()==null){
						LinkedList<MovieScheduleBean> list=new LinkedList<>();
						s.setServerSchedule(list);
					}
					bean.setMovieEndTime(schedule.getScheduleEnd().toString());
					bean.setMovieName(schedule.getMovieName());
					bean.setRuntimeInMins(schedule.getRuntime());
					bean.setServer(schedule.getServer());
					bean.setMovieStartTime(schedule.getSheduleDate().toString());
					s.getServerSchedule().add(bean);
					movieServerRepo.save(s).subscribe();
					return scheduleRepo.save(schedule);
					});
				

		});		
	}

	public Flux<MovieServers> saveServers(List<MovieServers> servers){
		return movieServerRepo.saveAll(servers);
	}
	
	public Flux<MovieServerBean> findAllServer(){
		return movieServerRepo.findAll().map(e->{	
			MovieServerBean bean= new MovieServerBean();
			bean.setServerName(e.getServerName());bean.setServerSchedule(e.getServerSchedule());
			bean.setLastMovieEndTime(e.getLastMovieEndTime().toString());bean.setServerStatus(e.getServerStatus());
			return bean;
		}).delayElements(Duration.ofSeconds(1));
		
	}
	
	public Flux<MovieSchedule> getAllSchedule(){
		return scheduleRepo.findAll();
	}
	
	public Mono<MovieSchedule> deleteSchedule(String id){
		return scheduleRepo.deleteByMovieId(id);
	}
	
	public Flux<Object> resetAllSchedule(){
		
		scheduleRepo.deleteAll().subscribe();
		return movieServerRepo.findAll().map(e->{
			e.getServerSchedule().clear();
			return movieServerRepo.save(e).subscribe();
		});
		

	}
	
	public Flux<MovieScheduleBean> currentlyStreaming(){
		return scheduleRepo.findAll().filter(e-> e.getScheduleEnd().after(new Date()) && e.getSheduleDate().before(new Date())).map(e->{
			MovieScheduleBean m=new MovieScheduleBean();
			m.setMovieName(e.getMovieName());
			m.setRuntimeInMins(e.getRuntime());
			m.setMovieEndTime(new SimpleDateFormat("HH:mm:ss").format(e.getScheduleEnd()));
			m.setServer(e.getServer());
			m.setMovieStartTime(e.getSheduleDate().toString());
			return m;
		}).defaultIfEmpty(new MovieScheduleBean()).delaySubscription(Duration.ofSeconds(10)).delayElements(Duration.ofSeconds(1)).repeat();
	}
}
