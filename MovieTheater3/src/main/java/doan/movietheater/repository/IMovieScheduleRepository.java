/*
 * (C) Copyright 2019 Fresher Academy. All Rights Reserved 
 *
 *	@author HCD-Fresher009
 *	@date Oct 18, 2019
 *	@version 1.0
 */

package doan.movietheater.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import doan.movietheater.entity.MovieSchedule;
import doan.movietheater.entity.MovieScheduleId;

@Repository
public interface IMovieScheduleRepository extends JpaRepository<MovieSchedule, MovieScheduleId> {
	@Query(value = "SELECT * FROM Movie_Schedule WHERE MovieID = ?1", nativeQuery = true)
	List<MovieSchedule> listMovieSchedule(String id);

	@Query(value = "SELECT * FROM Movie_Schedule WHERE MovieID = ?1 and ScheduleID = ?2", nativeQuery = true)
	MovieSchedule movieScheduleChoose(String movieID, int scheduleID);
}
