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

import doan.movietheater.entity.MovieSchedule;
import doan.movietheater.entity.MovieScheduleId;
import doan.movietheater.repository.IMovieScheduleRepository;
import doan.movietheater.service.IMovieScheduleService;

@Service
public class MovieScheduleServiceImpl implements IMovieScheduleService {

	@Autowired
	IMovieScheduleRepository movieScheduleRepository;

	@Override
	public List<MovieSchedule> getListMovieSchedule() {
		return movieScheduleRepository.findAll();
	}

	@Override
	public MovieSchedule getMovieScheduleById(MovieScheduleId id) {
		return movieScheduleRepository.findOne(id);
	}

	@Override
	public void addOrEditMovieSchedule(MovieSchedule movieSchedule) {
		movieScheduleRepository.save(movieSchedule);
	}

	@Override
	public void deleteMovieSchedule(MovieScheduleId id) {
		movieScheduleRepository.delete(id);
	}

	/**
	 * The function gets movie showtimes information by MovieID
	 */
	@Override
	public List<MovieSchedule> listMovieSchedule(String id) {
		return movieScheduleRepository.listMovieSchedule(id);
	}

	/**
	 * The function get movie showtime information by MovieID and ScheduleID
	 */
	@Override
	public MovieSchedule movieScheduleChoose(String movieID, int scheduleID) {
		return movieScheduleRepository.movieScheduleChoose(movieID, scheduleID);
	}
}
