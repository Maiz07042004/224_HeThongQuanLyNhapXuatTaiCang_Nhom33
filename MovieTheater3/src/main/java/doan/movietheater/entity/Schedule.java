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

import javax.persistence.CascadeType;
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
@Table(name = "Schedule")
@SQLDelete(sql = "update Schedule set delete_flag = 1 where schedule_id = ?")
@Where(clause = "delete_flag <> 1")
public class Schedule implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "schedule_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int scheduleID;

	@Column(name = "schedule_time", length = 255)
	private String scheduleTime;

	@Column(name = "delete_flag")
	private int deleteFlag;

	@OneToMany(mappedBy = "schedule", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<MovieSchedule> listMovieSchedule;

	@OneToMany(mappedBy = "schedule", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ScheduleSeat> listScheduleSeat;

	public Schedule() {
		super();
	}

	public Schedule(int scheduleID, String scheduleTime, int deleteFlag) {
		super();
		this.scheduleID = scheduleID;
		this.scheduleTime = scheduleTime;
		this.deleteFlag = deleteFlag;
	}

	public int getScheduleID() {
		return scheduleID;
	}

	public void setScheduleID(int scheduleID) {
		this.scheduleID = scheduleID;
	}

	public String getScheduleTime() {
		return scheduleTime;
	}

	public void setScheduleTime(String scheduleTime) {
		this.scheduleTime = scheduleTime;
	}

	public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public List<MovieSchedule> getListMovieSchedule() {
		return listMovieSchedule;
	}

	public void setListMovieSchedule(List<MovieSchedule> listMovieSchedule) {
		this.listMovieSchedule = listMovieSchedule;
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

}
