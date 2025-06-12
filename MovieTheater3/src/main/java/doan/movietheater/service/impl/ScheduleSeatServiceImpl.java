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

import doan.movietheater.entity.ScheduleSeat;
import doan.movietheater.repository.IScheduleSeatRepository;
import doan.movietheater.service.IScheduleSeatService;

@Service
public class ScheduleSeatServiceImpl implements IScheduleSeatService {

	@Autowired
	IScheduleSeatRepository scheduleRepository;

	@Override
	public List<ScheduleSeat> getListMovie() {
		return scheduleRepository.findAll();
	}
	

	@Override
	public void addOrEditMovie(ScheduleSeat scheduleSeat) {
		scheduleRepository.save(scheduleSeat);
	}


	/**
	 * Function takes the list of seats by movieID, showDateID and scheduleID
	 */
	@Override
	public List<ScheduleSeat> listSeat(String movieID, int showDateID, int scheduleID) {
		return scheduleRepository.listSeat(movieID, showDateID, scheduleID);
	}

	/**
	 * The function takes a list of chair columns by movieID, showDateID and
	 * scheduleID
	 */
	@Override
	public List<String> listSeatColumn(String movieID, int showDateID, int scheduleID) {
		return scheduleRepository.listSeatColumn(movieID, showDateID, scheduleID);
	}

	/**
	 * The function takes a list of chair rows by movieID, showDateID and scheduleID
	 */
	@Override
	public List<Integer> listSeatRow(String movieID, int showDateID, int scheduleID) {
		return scheduleRepository.listSeatRow(movieID, showDateID, scheduleID);
	}


	@Override
	public ScheduleSeat getMovieById(String id) {
		return scheduleRepository.findOne(id);
	}


	@Override
	public void deleteMovie(String id) {
		scheduleRepository.delete(id);		
	}


	@Override
	public ScheduleSeat getScheduleSeatById(String id) {
		return scheduleRepository.findOne(id);
	}
	
	public List<Object[]> listThongkeSLV(String movieID) {
		return scheduleRepository.listThongkeSLV(movieID);
	}
	
}
