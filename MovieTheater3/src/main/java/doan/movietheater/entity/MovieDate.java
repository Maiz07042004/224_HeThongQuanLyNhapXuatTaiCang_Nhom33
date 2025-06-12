/*
 * (C) Copyright 2019 Fresher Academy. All Rights Reserved 
 *
 *	@author HCD-Fresher009
 *	@date Oct 18, 2019
 *	@version 1.0
 */

package doan.movietheater.entity;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

@Entity
@Table(name = "Movie_Date")
@Where(clause = "delete_flag <> 1") 
public class MovieDate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "movieID", column = @Column(name = "MovieID", length = 10)),
			@AttributeOverride(name = "showDateID", column = @Column(name = "ShowDateID")) })
	private MovieDateId id;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "movieID", insertable = false, updatable = false)
	private Movie movie;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "showDateID", insertable = false, updatable = false)
	private ShowDates showDates;

	@Column(name = "delete_flag")
	private int deleteFlag;

	public MovieDate() {
		super();
	}

	public MovieDate(MovieDateId id, Movie movie, ShowDates showDates, int deleteFlag) {
		super();
		this.id = id;
		this.movie = movie;
		this.showDates = showDates;
		this.deleteFlag = deleteFlag;
	}

	public MovieDateId getId() {
		return id;
	}

	public void setId(MovieDateId id) {
		this.id = id;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public ShowDates getShowDates() {
		return showDates;
	}

	public void setShowDates(ShowDates showDates) {
		this.showDates = showDates;
	}

	public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
