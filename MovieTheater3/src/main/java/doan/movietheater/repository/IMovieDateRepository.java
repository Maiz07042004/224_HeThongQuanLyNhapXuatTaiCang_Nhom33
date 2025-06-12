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

import doan.movietheater.entity.MovieDate;
import doan.movietheater.entity.MovieDateId;

@Repository
public interface IMovieDateRepository extends JpaRepository<MovieDate, MovieDateId> {
	@Query(value = "SELECT * FROM Movie_Date WHERE ShowDateID = ?1", nativeQuery = true)
	List<MovieDate> listMovieDate(int id);

	@Query(value = "SELECT * FROM Movie_Date WHERE MovieID = ?1 and ShowDateID = ?2", nativeQuery = true)
	MovieDate movieDateChoose(String movieID, int showDateID);
	
}
