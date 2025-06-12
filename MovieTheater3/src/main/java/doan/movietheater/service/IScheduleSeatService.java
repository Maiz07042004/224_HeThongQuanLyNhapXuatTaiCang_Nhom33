/*
 * (C) Copyright 2019 Fresher Academy. All Rights Reserved 
 *
 *	@author HCD-Fresher009
 *	@date Oct 18, 2019
 *	@version 1.0
 */

package doan.movietheater.service;

import java.util.List;

import doan.movietheater.entity.ScheduleSeat;

public interface IScheduleSeatService {
	public List<ScheduleSeat> getListMovie();

	public ScheduleSeat getMovieById(String id);

	public void addOrEditMovie(ScheduleSeat scheduleSeat);

	public void deleteMovie(String id);

	List<ScheduleSeat> listSeat(String movieID, int showDateID, int scheduleID);

	List<String> listSeatColumn(String movieID, int showDateID, int scheduleID);

	List<Integer> listSeatRow(String movieID, int showDateID, int scheduleID);
	
	public ScheduleSeat getScheduleSeatById(String id);
}
