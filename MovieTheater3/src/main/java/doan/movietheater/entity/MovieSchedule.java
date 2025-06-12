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
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

@Entity
@Table(name = "Movie_Schedule")
@Where(clause = "delete_flag <> 1")
public class MovieSchedule implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "movieID", column = @Column(name = "MovieID", length = 10)),
			@AttributeOverride(name = "scheduleID", column = @Column(name = "ScheduleID")) })
	private MovieScheduleId id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "movieID", insertable = false, updatable = false)
	private Movie movie;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "scheduleID", insertable = false, updatable = false )
	private Schedule schedule;

	@Column(name = "delete_flag")
	private int deleteFlag;

	public MovieSchedule() {
		super();
	}

	public MovieSchedule(MovieScheduleId id, Movie movie, Schedule schedule, int deleteFlag) {
		super();
		this.id = id;
		this.movie = movie;
		this.schedule = schedule;
		this.deleteFlag = deleteFlag;
	}

	public MovieScheduleId getId() {
		return id;
	}

	public void setId(MovieScheduleId id) {
		this.id = id;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
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
