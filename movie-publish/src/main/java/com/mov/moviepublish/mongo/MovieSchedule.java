package com.mov.moviepublish.mongo;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class MovieSchedule {
	
	@Id
	private String id;
	
	private String server;
	
	private String movieId;
	
	private String movieName;
	
	private Date sheduleDate;
	
	private Integer runtime;
	
	private Date scheduleEnd;

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public Date getScheduleEnd() {
		return scheduleEnd;
	}

	public void setScheduleEnd(Date scheduleEnd) {
		this.scheduleEnd = scheduleEnd;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public Date getSheduleDate() {
		return sheduleDate;
	}

	public void setSheduleDate(Date sheduleDate) {
		this.sheduleDate = sheduleDate;
	}

	public Integer getRuntime() {
		return runtime;
	}

	public void setRuntime(Integer runtime) {
		this.runtime = runtime;
	}
	
	
	

}
