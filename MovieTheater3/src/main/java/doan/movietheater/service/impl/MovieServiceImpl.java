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

import doan.movietheater.entity.Movie;
import doan.movietheater.repository.IMovieRepository;
import doan.movietheater.service.IMovieService;

@Service
public class MovieServiceImpl implements IMovieService {
	@Autowired
	private IMovieRepository movieRepository;

	@Override
	public List<Movie> getListMovie() {
		return movieRepository.findAll();
	}

	@Override
	public Movie getMovieById(String id) {
		return movieRepository.findOne(id);
	}

	@Override
	public void addOrEditMovie(Movie movie) {
		movieRepository.save(movie);
	}
	
	@Override
	public void deleteMovie(String id) {
		movieRepository.delete(id);
	}

	@Override
	public Movie getAllMovieByID(String id) {
		return movieRepository.getAllMovieByID(id);
	}

	@Override
	public List<Movie> getMovieByName(String movieName) {
		return movieRepository.getMovieByName(movieName);
	}
	
//	public List<Object[]> listThongkeSLVThang(String movieID) {
//		return movieRepository.listThongkeSLVtheoThang(movieID);
//	}

}
