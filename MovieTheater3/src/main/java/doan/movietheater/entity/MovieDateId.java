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
public class MovieDateId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "MovieID")
	private String movieID;

	@Column(name = "ShowDateID")
	private int showDateID;

	public MovieDateId() {
		super();
	}

	public MovieDateId(String movieID, int showDateID) {
		super();
		this.movieID = movieID;
		this.showDateID = showDateID;
	}

	public String getMovieID() {
		return movieID;
	}

	public void setMovieID(String movieID) {
		this.movieID = movieID;
	}

	public int getShowDateID() {
		return showDateID;
	}

	public void setShowDateID(int showDateID) {
		this.showDateID = showDateID;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
