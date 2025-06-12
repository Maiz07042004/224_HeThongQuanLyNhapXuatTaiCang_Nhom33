/*
 * (C) Copyright 2019 Fresher Academy. All Rights Reserved 
 *
 *	@author HCD-Fresher009
 *	@date Oct 18, 2019
 *	@version 1.0
 */

package doan.movietheater.service;

import java.util.List;

import doan.movietheater.entity.MovieDate;
import doan.movietheater.entity.MovieDateId;

public interface IMovieDateService {
	public List<MovieDate> getListMovieDate();

	public MovieDate getMovieDateById(MovieDateId id);

	public void addOrEditMovieDate(MovieDate movieDate);
	
	public void deleteMovieDate(MovieDateId id);
	
	List<MovieDate> listMovieDate(int id);

	MovieDate movieDateChoose(String movieID, int showDateID);
}
