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
@Table(name = "Cinema_Room")
@SQLDelete(sql = "update Cinema_Room set delete_flag = 1 where cinema_room_id = ?")
@Where(clause = "delete_flag <> 1")
public class CinemaRoom implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cinema_room_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cinemaRoomID;

	@Column(name = "cinema_room_name", length = 255)
	private String cinemaRoomName;

	@Column(name = "seat_quantity")
	private int seatQuantity;

	@Column(name = "delete_flag")
	private int deleteFlag;

	@OneToMany(mappedBy = "cinemaRoom", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Seat> listSeat;

	@OneToMany(mappedBy = "cinemaRoom", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Movie> listMovie;

	public CinemaRoom() {
		super();
	}

	public CinemaRoom(int cinemaRoomID, String cinemaRoomName, int seatQuantity, int deleteFlag) {
		super();
		this.cinemaRoomID = cinemaRoomID;
		this.cinemaRoomName = cinemaRoomName;
		this.seatQuantity = seatQuantity;
		this.deleteFlag = deleteFlag;
	}

	public int getCinemaRoomID() {
		return cinemaRoomID;
	}

	public void setCinemaRoomID(int cinemaRoomID) {
		this.cinemaRoomID = cinemaRoomID;
	}

	public String getCinemaRoomName() {
		return cinemaRoomName;
	}

	public void setCinemaRoomName(String cinemaRoomName) {
		this.cinemaRoomName = cinemaRoomName;
	}

	public int getSeatQuantity() {
		return seatQuantity;
	}

	public void setSeatQuantity(int seatQuantity) {
		this.seatQuantity = seatQuantity;
	}

	public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public List<Seat> getListSeat() {
		return listSeat;
	}

	public void setListSeat(List<Seat> listSeat) {
		this.listSeat = listSeat;
	}

	public List<Movie> getListMovie() {
		return listMovie;
	}

	public void setListMovie(List<Movie> listMovie) {
		this.listMovie = listMovie;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
