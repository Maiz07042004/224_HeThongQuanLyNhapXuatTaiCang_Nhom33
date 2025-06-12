/*
 * (C) Copyright 2019 Fresher Academy. All Rights Reserved 
 *
 *	@author HCD-Fresher009
 *	@date Oct 18, 2019
 *	@version 1.0
 */

package doan.movietheater.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "Schedule_Seat")
@SQLDelete(sql = "update Schedule_Seat set delete_flag = 1 where schedule_seat_id = ?")
@Where(clause = "delete_flag <> 1")
public class ScheduleSeat implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "schedule_seat_id")
	private String scheduleSeatID;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "movieID")
	private Movie movie;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "showDateID")
	private ShowDates showDates;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "scheduleID")
	private Schedule schedule;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "seatID")
	private Seat seat;

	@Column(name = "seat_column", length = 255)
	private String seatColumn;

	@Column(name = "seat_row")
	private int seatRow;

	@Column(name = "seat_status")
	private int seatStatus;

	@Column(name = "seat_type")
	private int seatType;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ticketID")
	private Ticket ticket;

	@Column(name = "delete_flag")
	private int deleteFlag;

	public ScheduleSeat() {
		super();
	}

	public ScheduleSeat(String scheduleSeatID, Movie movie, ShowDates showDates, Schedule schedule, Seat seat,
			String seatColumn, int seatRow, int seatStatus, int seatType, Ticket ticket, int deleteFlag) {
		super();
		this.scheduleSeatID = scheduleSeatID;
		this.movie = movie;
		this.showDates = showDates;
		this.schedule = schedule;
		this.seat = seat;
		this.seatColumn = seatColumn;
		this.seatRow = seatRow;
		this.seatStatus = seatStatus;
		this.seatType = seatType;
		this.ticket = ticket;
		this.deleteFlag = deleteFlag;
	}

	public String getScheduleSeatID() {
		return scheduleSeatID;
	}

	public void setScheduleSeatID(String scheduleSeatID) {
		this.scheduleSeatID = scheduleSeatID;
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

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public String getSeatColumn() {
		return seatColumn;
	}

	public void setSeatColumn(String seatColumn) {
		this.seatColumn = seatColumn;
	}

	public int getSeatRow() {
		return seatRow;
	}

	public void setSeatRow(int seatRow) {
		this.seatRow = seatRow;
	}

	public int getSeatStatus() {
		return seatStatus;
	}

	public void setSeatStatus(int seatStatus) {
		this.seatStatus = seatStatus;
	}

	public int getSeatType() {
		return seatType;
	}

	public void setSeatType(int seatType) {
		this.seatType = seatType;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public ShowDates getShowDates() {
		return showDates;
	}

	public void setShowDates(ShowDates showDates) {
		this.showDates = showDates;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
