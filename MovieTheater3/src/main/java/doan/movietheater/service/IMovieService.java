/*
 * (C) Copyright 2019 Fresher Academy. All Rights Reserved 
 *
 *	@author HCD-Fresher009
 *	@date Oct 18, 2019
 *	@version 1.0
 */

package doan.movietheater.service;

import java.util.List;

import doan.movietheater.entity.Movie;

public interface IMovieService {
	public List<Movie> getListMovie();
	
	public Movie getAllMovieByID(String id);

	public Movie getMovieById(String id);
	
	public List<Movie> getMovieByName(String movieName);

	public void addOrEditMovie(Movie movie);

	public void deleteMovie(String id);

}
