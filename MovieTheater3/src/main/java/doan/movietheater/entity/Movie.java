/*
 * (C) Copyright 2019 Fresher Academy. All Rights Reserved 
 *
 *	@author HCD-Fresher009
 *	@date Oct 18, 2019
 *	@version 1.0
 */

package doan.movietheater.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Movie")
@SQLDelete(sql = "update Movie set delete_flag = 1 where movie_id = ?")
@Where(clause = "delete_flag <> 1")
public class Movie implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "movie_id", length = 10)
	private String movieID;

	@Column(name = "actor", length = 255)
	private String actor;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "cinemaRoomID")
	private CinemaRoom cinemaRoom;

	@Column(name = "content", columnDefinition = "varchar(MAX)")
	private String content;

	@Column(name = "director", length = 255)
	private String director;

	@Column(name = "duration")
	private int duration;

	@Column(name = "from_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fromDate;

	@Column(name = "movie_production_company", length = 255)
	private String movieProductionCompany;

	@Column(name = "to_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate toDate;

	@Column(name = "version", length = 255)
	private String version;

	@Column(name = "movie_name_english", length = 255)
	private String movieNameEnglish;

	@Column(name = "movie_name_vn", length = 255)
	private String movieNameVN;

	@Column(name = "lagre_image", length = 255)
	private String lagreImage;

	@Column(name = "small_image", length = 255)
	private String smallImage;

	@Column(name = "delete_flag")
	private int deleteFlag;

	@OneToMany(mappedBy = "movie", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<MovieType> listMovieType;

	@OneToMany(mappedBy = "movie", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<MovieSchedule> listMovieSchedule;

	@OneToMany(mappedBy = "movie", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<MovieDate> listMovieDate;

	@OneToMany(mappedBy = "movie", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ScheduleSeat> listScheduleSeat;

	public Movie() {
		super();
	}

	public Movie(String movieID, String actor, String content, String director, int duration, LocalDate fromDate,
			String movieProductionCompany, LocalDate toDate, String version, String movieNameEnglish,
			String movieNameVN, String lagreImage, String smallImage) {
		super();
		this.movieID = movieID;
		this.actor = actor;
		this.content = content;
		this.director = director;
		this.duration = duration;
		this.fromDate = fromDate;
		this.movieProductionCompany = movieProductionCompany;
		this.toDate = toDate;
		this.version = version;
		this.movieNameEnglish = movieNameEnglish;
		this.movieNameVN = movieNameVN;
		this.lagreImage = lagreImage;
		this.smallImage = smallImage;
	}

	public String getMovieID() {
		return movieID;
	}

	public void setMovieID(String movieID) {
		this.movieID = movieID;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public String getMovieProductionCompany() {
		return movieProductionCompany;
	}

	public void setMovieProductionCompany(String movieProductionCompany) {
		this.movieProductionCompany = movieProductionCompany;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getMovieNameEnglish() {
		return movieNameEnglish;
	}

	public void setMovieNameEnglish(String movieNameEnglish) {
		this.movieNameEnglish = movieNameEnglish;
	}

	public String getMovieNameVN() {
		return movieNameVN;
	}

	public void setMovieNameVN(String movieNameVN) {
		this.movieNameVN = movieNameVN;
	}

	public String getLagreImage() {
		return lagreImage;
	}

	public void setLagreImage(String lagreImage) {
		this.lagreImage = lagreImage;
	}

	public String getSmallImage() {
		return smallImage;
	}

	public void setSmallImage(String smallImage) {
		this.smallImage = smallImage;
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

	public List<MovieSchedule> getListMovieSchedule() {
		return listMovieSchedule;
	}

	public void setListMovieSchedule(List<MovieSchedule> listMovieSchedule) {
		this.listMovieSchedule = listMovieSchedule;
	}

	public List<MovieDate> getListMovieDate() {
		return listMovieDate;
	}

	public void setListMovieDate(List<MovieDate> listMovieDate) {
		this.listMovieDate = listMovieDate;
	}

	public List<ScheduleSeat> getListScheduleSeat() {
		return listScheduleSeat;
	}

	public void setListScheduleSeat(List<ScheduleSeat> listScheduleSeat) {
		this.listScheduleSeat = listScheduleSeat;
	}

	public CinemaRoom getCinemaRoom() {
		return cinemaRoom;
	}

	public void setCinemaRoom(CinemaRoom cinemaRoom) {
		this.cinemaRoom = cinemaRoom;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
