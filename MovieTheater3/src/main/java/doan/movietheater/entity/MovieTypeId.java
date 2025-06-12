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
public class MovieTypeId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "movieID")
	private String movieID;

	@Column(name = "typeMovieID")
	private int typeMovieID;

	public MovieTypeId() {
		super();
	}

	public MovieTypeId(String movieID, int typeMovieID) {
		super();
		this.movieID = movieID;
		this.typeMovieID = typeMovieID;
	}

	public String getMovieID() {
		return movieID;
	}

	public void setMovieID(String movieID) {
		this.movieID = movieID;
	}

	public int getTypeMovieID() {
		return typeMovieID;
	}

	public void setTypeMovieID(int typeMovieID) {
		this.typeMovieID = typeMovieID;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
