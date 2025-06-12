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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "Seat")
@SQLDelete(sql = "update Seat set delete_flag = 1 where seat_id = ?")
@Where(clause = "delete_flag <> 1")
public class Seat implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "seat_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int seatID;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "cinemaRoomID")
	private CinemaRoom cinemaRoom;

	@Column(name = "seat_column", length = 255)
	private String seatColumn;

	@Column(name = "seat_row")
	private int seatRow;

	@Column(name = "seat_status")
	private int seatStatus;

	@Column(name = "seat_type")
	private int seatType;

	@Column(name = "delete_flag")
	private int deleteFlag;

	@OneToMany(mappedBy = "seat", fetch = FetchType.LAZY)
	private List<ScheduleSeat> listScheduleSeat;

	public Seat() {
		super();
	}

	public Seat(int seatID, CinemaRoom cinemaRoom, String seatColumn, int seatRow, int seatStatus, int seatType,
			int deleteFlag) {
		super();
		this.seatID = seatID;
		this.cinemaRoom = cinemaRoom;
		this.seatColumn = seatColumn;
		this.seatRow = seatRow;
		this.seatStatus = seatStatus;
		this.seatType = seatType;
		this.deleteFlag = deleteFlag;
	}

	public int getSeatID() {
		return seatID;
	}

	public void setSeatID(int seatID) {
		this.seatID = seatID;
	}

	public CinemaRoom getCinemaRoom() {
		return cinemaRoom;
	}

	public void setCinemaRoom(CinemaRoom cinemaRoom) {
		this.cinemaRoom = cinemaRoom;
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

	public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
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

	@Override
	public String toString() {
		return "Seat [seatID=" + seatID + ", cinemaRoom=" + cinemaRoom + ", seatColumn=" + seatColumn + ", seatRow="
				+ seatRow + ", seatStatus=" + seatStatus + ", seatType=" + seatType + ", deleteFlag=" + deleteFlag
				+ "]";
	}
	
	
}
