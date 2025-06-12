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

import doan.movietheater.entity.Schedule;
import doan.movietheater.repository.IScheduleRepository;
import doan.movietheater.service.IScheduleService;

@Service
public class ScheduleServiceImpl implements IScheduleService {

	@Autowired
	private IScheduleRepository scheduleRepository;

	@Override
	public List<Schedule> getListSchedule() {
		return scheduleRepository.findAll();
	}

	@Override
	public Schedule getScheduleById(int id) {
		return scheduleRepository.findOne(id);
	}

	@Override
	public void addOrEditSchedule(Schedule schedule) {
		scheduleRepository.save(schedule);
	}

	@Override
	public void deleteSchedule(int id) {
		scheduleRepository.delete(id);
	}

}
