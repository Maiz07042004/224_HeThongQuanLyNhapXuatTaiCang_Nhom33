/*
 * (C) Copyright 2019 Fresher Academy. All Rights Reserved 
 *
 *	@author HCD-Fresher009
 *	@date Oct 18, 2019
 *	@version 1.0
 */

package doan.movietheater.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MovieScheduleId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "movieID")
	private String movieID;

	@Column(name = "scheduleID")
	private int scheduleID;

	public MovieScheduleId() {
		super();
	}

	public MovieScheduleId(String movieID, int scheduleID) {
		super();
		this.movieID = movieID;
		this.scheduleID = scheduleID;
	}

	public String getMovieID() {
		return movieID;
	}

	public void setMovieID(String movieID) {
		this.movieID = movieID;
	}

	public int getScheduleID() {
		return scheduleID;
	}

	public void setScheduleID(int scheduleID) {
		this.scheduleID = scheduleID;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
