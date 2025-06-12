/*
 * (C) Copyright 2019 Fresher Academy. All Rights Reserved 
 *
 *	@author HCD-Fresher009
 *	@date Oct 18, 2019
 *	@version 1.0
 */

package doan.movietheater.service;

import java.util.List;

import doan.movietheater.entity.TypeMovie;

public interface ITypeMovieService {
	public List<TypeMovie> getListTypeMovie();

	public TypeMovie getTypeMovieById(int id);

	public void addOrEditTypeMovie(TypeMovie computer);

	public void deleteTypeMovie(int id);

}
