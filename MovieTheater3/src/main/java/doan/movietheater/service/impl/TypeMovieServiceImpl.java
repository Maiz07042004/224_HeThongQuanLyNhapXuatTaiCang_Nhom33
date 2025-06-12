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

import doan.movietheater.entity.TypeMovie;
import doan.movietheater.repository.ITypeMovieRepository;
import doan.movietheater.service.ITypeMovieService;

@Service
public class TypeMovieServiceImpl implements ITypeMovieService {

	@Autowired
	ITypeMovieRepository typeMovieRepository;

	@Override
	public List<TypeMovie> getListTypeMovie() {
		return typeMovieRepository.findAll();
	}

	@Override
	public TypeMovie getTypeMovieById(int id) {
		return typeMovieRepository.findOne(id);
	}

	@Override
	public void addOrEditTypeMovie(TypeMovie typeMovie) {
		typeMovieRepository.save(typeMovie);
	}

	@Override
	public void deleteTypeMovie(int id) {
		typeMovieRepository.delete(id);
	}

}
