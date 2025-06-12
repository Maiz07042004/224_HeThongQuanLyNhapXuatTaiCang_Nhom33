/*
 * (C) Copyright 2019 Fresher Academy. All Rights Reserved 
 *
 *	@author HCD-Fresher009
 *	@date Oct 18, 2019
 *	@version 1.0
 */

package doan.movietheater.service;

import java.util.List;

import doan.movietheater.entity.Seat;

public interface ISeatService {
	public List<Seat> getListSeat();

	public Seat getSeatById(int id);

	public void addOrEditSeat(Seat seat);

	public void deleteSeat(int id);
	
	public void deleteSeatRow(int roomID);
}
