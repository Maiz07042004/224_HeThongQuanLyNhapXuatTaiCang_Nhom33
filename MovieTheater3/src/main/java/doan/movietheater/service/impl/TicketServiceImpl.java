/*
 * (C) Copyright 2019 Fresher Academy. All Rights Reserved 
 *
 *	@author HCD-Fresher009
 *	@date Oct 18, 2019
 *	@version 1.0
 */

package doan.movietheater.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import doan.movietheater.entity.Ticket;
import doan.movietheater.repository.ITicketRepository;
import doan.movietheater.service.ITicketService;

@Service
public class TicketServiceImpl implements ITicketService {

	@Autowired
	ITicketRepository ticketRepository;

	@Override
	public List<Ticket> getListMovie() {
		return ticketRepository.findAll();
	}

	@Override
	public Ticket getMovieById(int id) {
		return ticketRepository.findOne(id);
	}

	@Override
	public void addOrEditMovie(Ticket ticket) {
		ticketRepository.save(ticket);
	}

	@Override
	public void deleteMovie(int id) {
		ticketRepository.delete(id);
	}

}
