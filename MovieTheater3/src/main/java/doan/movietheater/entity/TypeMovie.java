/*
 * (C) Copyright 2019 Fresher Academy. All Rights Reserved 
 *
 *	@author HCD-Fresher009
 *	@date Oct 18, 2019
 *	@version 1.0
 */

package doan.movietheater.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "Type_Movie")
@SQLDelete(sql = "update Type_Movie set delete_flag = 1 where type_movie_id = ?")
@Where(clause = "delete_flag <> 1")
public class TypeMovie implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "type_movie_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int typeMovieID;

	@Column(name = "type_movie_name", length = 255)
	private String typeMovieName;

	@Column(name = "delete_flag")
	private int deleteFlag;

	@OneToMany(mappedBy = "typeMovie", fetch = FetchType.LAZY)
	private List<MovieType> listMovieType;

	public TypeMovie() {
		super();
	}

	public TypeMovie(int typeMovieID, String typeMovieName) {
		super();
		this.typeMovieID = typeMovieID;
		this.typeMovieName = typeMovieName;
	}

	public int getTypeMovieID() {
		return typeMovieID;
	}

	public void setTypeMovieID(int typeMovieID) {
		this.typeMovieID = typeMovieID;
	}

	public String getTypeMovieName() {
		return typeMovieName;
	}

	public void setTypeMovieName(String typeMovieName) {
		this.typeMovieName = typeMovieName;
	}

	public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public List<MovieType> getListMovieType() {
		return listMovieType;
	}

	public void setListMovieType(List<MovieType> listMovieType) {
		this.listMovieType = listMovieType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
