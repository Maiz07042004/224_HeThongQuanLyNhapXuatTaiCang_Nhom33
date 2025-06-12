/*
 * (C) Copyright 2019 Fresher Academy. All Rights Reserved 
 *
 *	@author HCD-Fresher009
 *	@date Oct 18, 2019
 *	@version 1.0
 */

package doan.movietheater.service;

import java.util.List;

import doan.movietheater.entity.CinemaRoom;

public interface ICinemaRoomService {
	public List<CinemaRoom> getListMovie();

	public CinemaRoom getMovieById(int id);

	public void addOrEditMovie(CinemaRoom cinemaRoom);

	public void deleteMovie(int id);
}
