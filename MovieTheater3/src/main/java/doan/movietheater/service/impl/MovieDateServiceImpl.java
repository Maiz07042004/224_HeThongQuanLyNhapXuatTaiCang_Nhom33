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

import doan.movietheater.entity.MovieDate;
import doan.movietheater.entity.MovieDateId;
import doan.movietheater.repository.IMovieDateRepository;
import doan.movietheater.service.IMovieDateService;

@Service
public class MovieDateServiceImpl implements IMovieDateService {

	@Autowired
	IMovieDateRepository movieDateRepository;

	@Override
	public List<MovieDate> getListMovieDate() {
		return movieDateRepository.findAll();
	}

	@Override
	public MovieDate getMovieDateById(MovieDateId id) {
		return movieDateRepository.findOne(id);
	}

	@Override
	public void addOrEditMovieDate(MovieDate movieDate) {
		movieDateRepository.save(movieDate);
	}

	@Override
	public void deleteMovieDate(MovieDateId id) {
		movieDateRepository.delete(id);
	}

	/**
	 * The function retrieves the movie list of the day according to ShowDateID
	 */
	@Override
	public List<MovieDate> listMovieDate(int id) {
		return movieDateRepository.listMovieDate(id);
	}

	/**
	 * The function retrieves the day's movie according to ShowDateID and MovieID
	 */
	@Override
	public MovieDate movieDateChoose(String movieID, int showDateID) {
		return movieDateRepository.movieDateChoose(movieID, showDateID);
	}

}
