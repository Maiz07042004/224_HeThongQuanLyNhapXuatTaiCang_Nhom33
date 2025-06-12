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

import doan.movietheater.entity.CinemaRoom;
import doan.movietheater.repository.ICinemaRoomRepository;
import doan.movietheater.service.ICinemaRoomService;

@Service
public class CinemaRoomServiceImpl implements ICinemaRoomService {

	@Autowired
	ICinemaRoomRepository cinemaRoomRepository;

	@Override
	public List<CinemaRoom> getListMovie() {
		return cinemaRoomRepository.findAll();
	}

	@Override
	public CinemaRoom getMovieById(int id) {
		return cinemaRoomRepository.findOne(id);
	}

	@Override
	public void addOrEditMovie(CinemaRoom cinemaRoom) {
		cinemaRoomRepository.save(cinemaRoom);
	}

	@Override
	public void deleteMovie(int id) {
		cinemaRoomRepository.delete(id);
	}

}
