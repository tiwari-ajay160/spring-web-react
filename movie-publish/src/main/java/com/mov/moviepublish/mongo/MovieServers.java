package com.mov.moviepublish.mongo;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mov.moviepublish.Beans.MovieScheduleBean;

@Document
@JsonIgnoreProperties(ignoreUnknown=true)
public class MovieServers {
	
	@Id
	private String id;
	
	private String serverName;
	
	private LinkedList<MovieScheduleBean> serverSchedule;
	
	private Date lastMovieEndTime;
	
	private Boolean serverStatus;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getServerName() {
		return serverName;
	}

	public Boolean getServerStatus() {
		return serverStatus;
	}

	public void setServerStatus(Boolean serverStatus) {
		this.serverStatus = serverStatus;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public LinkedList<MovieScheduleBean> getServerSchedule() {
		return serverSchedule;
	}

	public void setServerSchedule(LinkedList<MovieScheduleBean> serverSchedule) {
		this.serverSchedule = serverSchedule;
	}

	public Date getLastMovieEndTime() {
		return lastMovieEndTime;
	}

	public void setLastMovieEndTime(Date lastMovieEndTime) {
		this.lastMovieEndTime = lastMovieEndTime;
	}
	
	
	

}
