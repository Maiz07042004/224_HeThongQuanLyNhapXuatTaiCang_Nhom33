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

import doan.movietheater.entity.Movie;

@Repository
public interface IMovieRepository extends JpaRepository<Movie, String> {

	@Query(value = "select * from Movie where movie_id = ?1", nativeQuery = true)
	Movie getAllMovieByID(String id);
	
	@Query(value = "select * from Movie where movie_name_vn like %?1% or movie_name_english like %?1%", nativeQuery = true)
	List<Movie> getMovieByName(String movieName);
	
//	@Query(value = "SELECT ss.movieID, mv.movie_name_vn, ss.ticketID, COUNT(ss.movieID), Month(sd.show_date) FROM Schedule_Seat ss\r\n"
//			+ "Join Movie mv on ss.movieID = mv.movie_id\r\n"
//			+ "Join Show_Dates sd on ss.showDateID = sd.show_date_id\r\n"
//			+ "WHERE ss.seat_status=1 and ss.movieID = ?1 \r\n"
//			+ "Group by ss.movieID, ss.ticketID, sd.show_date, mv.movie_name_vn\r\n"
//			,nativeQuery = true)
//	List<Object[]> listThongkeSLVtheoThang(String movieID);
}
