/*
 * (C) Copyright 2019 Fresher Academy. All Rights Reserved 
 *
 *	@author HCD-Fresher009
 *	@date Oct 18, 2019
 *	@version 1.0
 */

package doan.movietheater.service;

import java.util.List;

import doan.movietheater.entity.MovieType;
import doan.movietheater.entity.MovieTypeId;

public interface IMovieTypeService {
	public List<MovieType> getListMovieType();

	public MovieType getMovieTypeById(MovieTypeId id);

	public void addOrEditMovieType(MovieType movieType);

	public void deleteMovieType(MovieTypeId id);
}
