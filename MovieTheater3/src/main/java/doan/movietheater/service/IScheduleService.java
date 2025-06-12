/*
 * (C) Copyright 2019 Fresher Academy. All Rights Reserved 
 *
 *	@author HCD-Fresher009
 *	@date Oct 18, 2019
 *	@version 1.0
 */

package doan.movietheater.service;

import java.util.List;

import doan.movietheater.entity.Schedule;

public interface IScheduleService {
	public List<Schedule> getListSchedule();

	public Schedule getScheduleById(int id);

	public void addOrEditSchedule(Schedule computer);

	public void deleteSchedule(int id);
}
