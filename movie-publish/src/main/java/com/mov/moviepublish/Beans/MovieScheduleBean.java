package com.mov.moviepublish.Beans;

import java.util.Date;


public class MovieScheduleBean {
	
	private String movieName;
	
	private Integer runtimeInMins;
	
	private String movieEndTime;
	private String movieStartTime;
	
	public String getMovieStartTime() {
		return movieStartTime;
	}

	public void setMovieStartTime(String movieStartTime) {
		this.movieStartTime = movieStartTime;
	}

	private String server;

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public Integer getRuntimeInMins() {
		return runtimeInMins;
	}

	public void setRuntimeInMins(Integer runtimeInMins) {
		this.runtimeInMins = runtimeInMins;
	}

	public String getMovieEndTime() {
		return movieEndTime;
	}

	public void setMovieEndTime(String movieEndTime) {
		this.movieEndTime = movieEndTime;
	}


}
