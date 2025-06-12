/*
 * (C) Copyright 2019 Fresher Academy. All Rights Reserved 
 *
 *	@author HCD-Fresher009
 *	@date Oct 18, 2019
 *	@version 1.0
 */

package doan.movietheater.service;

import java.time.LocalDate;
import java.util.List;

import doan.movietheater.entity.ShowDates;

public interface IShowDatesService {
	public List<ShowDates> getListShowDates();

	public ShowDates getShowDatesById(int id);

	public void addOrEditShowDates(ShowDates computer);

	public void deleteShowDates(int id);

	List<ShowDates> listShowDate(LocalDate date, LocalDate date2);
	
	public ShowDates checkShowDates(LocalDate date);
}
