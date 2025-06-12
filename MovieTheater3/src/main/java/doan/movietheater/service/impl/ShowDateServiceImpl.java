/*
 * (C) Copyright 2019 Fresher Academy. All Rights Reserved 
 *
 *	@author HCD-Fresher009
 *	@date Oct 18, 2019
 *	@version 1.0
 */

package doan.movietheater.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import doan.movietheater.entity.ShowDates;
import doan.movietheater.repository.IShowDatesRepository;
import doan.movietheater.service.IShowDatesService;

@Service
public class ShowDateServiceImpl implements IShowDatesService {

	@Autowired
	IShowDatesRepository showDatesRepository;

	@Override
	public List<ShowDates> getListShowDates() {
		return showDatesRepository.findAll();
	}

	@Override
	public ShowDates getShowDatesById(int id) {
		return showDatesRepository.findOne(id);
	}

	@Override
	public void addOrEditShowDates(ShowDates showDates) {
		showDatesRepository.save(showDates);
	}

	@Override
	public void deleteShowDates(int id) {
		showDatesRepository.delete(id);
	}

	/**
	 * The function gets 6 days from the current date
	 */
	@Override
	public List<ShowDates> listShowDate(LocalDate date, LocalDate date2) {
		return showDatesRepository.listShowDate(date, date2);
	}

	@Override
	public ShowDates checkShowDates(LocalDate date) {
		return showDatesRepository.checkShowdate(date);
	}

}
