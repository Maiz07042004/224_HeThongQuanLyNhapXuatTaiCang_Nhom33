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
import java.time.format.DateTimeFormatter;
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
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Show_Dates")
@SQLDelete(sql = "update Show_Dates set delete_flag = 1 where show_date_id = ?")
@Where(clause = "delete_flag <> 1")
public class ShowDates implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "show_date_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int showDateID;

	@Column(name = "show_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate showDate;

	@Column(name = "date_name", length = 255)
	private String dateName;

	@Column(name = "delete_flag")
	private int deleteFlag;

	@OneToMany(mappedBy = "showDates", fetch = FetchType.LAZY)
	private List<MovieDate> listMovieDate;

	@OneToMany(mappedBy = "showDates", fetch = FetchType.LAZY)
	private List<ScheduleSeat> listScheduleSeat;

	public ShowDates() {
		super();
	}

	public ShowDates(int showDateID, LocalDate showDate, String dateName, int deleteFlag,
			List<MovieDate> listMovieDate) {
		super();
		this.showDateID = showDateID;
		this.showDate = showDate;
		this.dateName = dateName;
		this.deleteFlag = deleteFlag;
		this.listMovieDate = listMovieDate;
	}

	public int getShowDateID() {
		return showDateID;
	}

	public void setShowDateID(int showDateID) {
		this.showDateID = showDateID;
	}

	public LocalDate getShowDate() {
		return showDate;
	}

	public void setShowDate(LocalDate showDate) {
		this.showDate = showDate;
	}

	public String getDateName() {
		return dateName;
	}

	public void setDateName(String dateName) {
		this.dateName = dateName;
	}

	public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String formartStartDate() {
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return showDate.format(formatters);
	}
}
