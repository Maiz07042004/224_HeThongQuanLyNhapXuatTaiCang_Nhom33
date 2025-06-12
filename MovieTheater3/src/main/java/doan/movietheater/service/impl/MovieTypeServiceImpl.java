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

import doan.movietheater.entity.MovieType;
import doan.movietheater.entity.MovieTypeId;
import doan.movietheater.repository.IMovieTypeRepository;
import doan.movietheater.service.IMovieTypeService;

@Service
public class MovieTypeServiceImpl implements IMovieTypeService {

	@Autowired
	IMovieTypeRepository movieTypeRepository;

	@Override
	public List<MovieType> getListMovieType() {
		return movieTypeRepository.findAll();
	}

	@Override
	public MovieType getMovieTypeById(MovieTypeId id) {
		return movieTypeRepository.findOne(id);
	}

	@Override
	public void addOrEditMovieType(MovieType movieType) {
		movieTypeRepository.save(movieType);
	}

	@Override
	public void deleteMovieType(MovieTypeId id) {
		movieTypeRepository.delete(id);
	}

}
