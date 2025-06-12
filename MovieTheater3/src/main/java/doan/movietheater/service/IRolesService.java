/*
 * (C) Copyright 2019 Fresher Academy. All Rights Reserved 
 *
 *	@author HCD-Fresher009
 *	@date Oct 18, 2019
 *	@version 1.0
 */

package doan.movietheater.service;

import java.util.List;

import doan.movietheater.entity.Roles;

public interface IRolesService {
	public List<Roles> getListMovie();

	public Roles getMovieById(int id);

	public void addOrEditMovie(Roles roles);

	public void deleteMovie(int id);
}
