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

import doan.movietheater.entity.Roles;
import doan.movietheater.repository.IRolesRepository;
import doan.movietheater.service.IRolesService;

@Service
public class RolesServiceImpl implements IRolesService {

	@Autowired
	IRolesRepository rolesRepository;

	@Override
	public List<Roles> getListMovie() {
		return rolesRepository.findAll();
	}

	@Override
	public Roles getMovieById(int id) {
		return rolesRepository.findOne(id);
	}

	@Override
	public void addOrEditMovie(Roles roles) {
		rolesRepository.save(roles);
	}

	@Override
	public void deleteMovie(int id) {
		rolesRepository.delete(id);
	}

}
