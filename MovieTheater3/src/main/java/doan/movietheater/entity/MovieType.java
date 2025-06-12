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
@Table(name = "Movie_Type")
@Where(clause = "delete_flag <> 1")
public class MovieType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "movieID", column = @Column(name = "MovieID", length = 10)),
			@AttributeOverride(name = "typeMovieID", column = @Column(name = "TypeMovieID")) })
	private MovieTypeId id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "movieID")
	private Movie movie;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "typeMovieID")
	private TypeMovie typeMovie;

	@Column(name = "delete_flag")
	private int deleteFlag;

	public MovieType() {
		super();
	}

	public MovieType(MovieTypeId id) {
		super();
		this.id = id;
	}

	public MovieType(MovieTypeId id, Movie movie, TypeMovie typeMovie) {
		super();
		this.id = id;
		this.movie = movie;
		this.typeMovie = typeMovie;
	}

	public MovieTypeId getId() {
		return id;
	}

	public void setId(MovieTypeId id) {
		this.id = id;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public TypeMovie getTypeMovie() {
		return typeMovie;
	}

	public void setTypeMovie(TypeMovie typeMovie) {
		this.typeMovie = typeMovie;
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
