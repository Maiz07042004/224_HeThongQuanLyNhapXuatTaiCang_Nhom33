/*
 * (C) Copyright 2019 Fresher Academy. All Rights Reserved 
 *
 *	@author HCD-Fresher009
 *	@date Oct 18, 2019
 *	@version 1.0
 */

package doan.movietheater.service;

import java.util.List;

import doan.movietheater.entity.MovieSchedule;
import doan.movietheater.entity.MovieScheduleId;

public interface IMovieScheduleService {
	public List<MovieSchedule> getListMovieSchedule();

	public MovieSchedule getMovieScheduleById(MovieScheduleId id);

	public void addOrEditMovieSchedule(MovieSchedule movieSchedule);

	public void deleteMovieSchedule(MovieScheduleId id);

	List<MovieSchedule> listMovieSchedule(String id);

	MovieSchedule movieScheduleChoose(String movieID, int scheduleID);
}
