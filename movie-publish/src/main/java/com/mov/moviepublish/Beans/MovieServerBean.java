package com.mov.moviepublish.Beans;

import java.util.Date;
import java.util.LinkedList;

public class MovieServerBean {
	
	private String serverName;
	
	private LinkedList<MovieScheduleBean> serverSchedule;
	
	private String lastMovieEndTime;
	
	private Boolean serverStatus;

	public String getServerName() {
		return serverName;
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

	public String getLastMovieEndTime() {
		return lastMovieEndTime;
	}

	public void setLastMovieEndTime(String lastMovieEndTime) {
		this.lastMovieEndTime = lastMovieEndTime;
	}

	public Boolean getServerStatus() {
		return serverStatus;
	}

	public void setServerStatus(Boolean serverStatus) {
		this.serverStatus = serverStatus;
	}
	
	

}
