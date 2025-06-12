/*
 * (C) Copyright 2019 Fresher Academy. All Rights Reserved 
 *
 *	@author HCD-Fresher009
 *	@date Oct 18, 2019
 *	@version 1.0
 */

package doan.movietheater.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import doan.movietheater.entity.ShowDates;

@Repository
public interface IShowDatesRepository extends JpaRepository<ShowDates, Integer> {
	@Query(value = "SELECT * FROM Show_Dates WHERE show_date between ?1 and ?2 order by show_date asc", nativeQuery = true)
	List<ShowDates> listShowDate(LocalDate date, LocalDate date2);
	
	@Query(value = "SELECT * FROM Show_Dates WHERE show_date = ?1", nativeQuery = true)
	ShowDates checkShowdate(LocalDate date);
}
