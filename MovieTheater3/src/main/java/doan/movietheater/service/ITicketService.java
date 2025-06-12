/*
 * (C) Copyright 2019 Fresher Academy. All Rights Reserved 
 *
 *	@author HCD-Fresher009
 *	@date Oct 18, 2019
 *	@version 1.0
 */

package doan.movietheater.service;

import java.util.List;

import doan.movietheater.entity.Ticket;

public interface ITicketService {
	public List<Ticket> getListMovie();

	public Ticket getMovieById(int id);

	public void addOrEditMovie(Ticket ticket);

	public void deleteMovie(int id);
}
