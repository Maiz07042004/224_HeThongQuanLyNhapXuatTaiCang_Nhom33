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

import doan.movietheater.entity.ScheduleSeat;

@Repository
public interface IScheduleSeatRepository extends JpaRepository<ScheduleSeat, String> {
	@Query(value = "SELECT * FROM Schedule_Seat WHERE movieID = ?1 and showDateID = ?2 and scheduleID = ?3 order by  seat_row asc, seat_column asc", nativeQuery = true)
	List<ScheduleSeat> listSeat(String movieID, int showDateID, int scheduleID);

	@Query(value = "select seat_column from Schedule_Seat where movieID = ?1 and showDateID = ?2 and scheduleID = ?3 group by seat_column", nativeQuery = true)
	List<String> listSeatColumn(String movieID, int showDateID, int scheduleID);

	@Query(value = "select seat_row from Schedule_Seat where movieID = ?1 and showDateID = ?2 and scheduleID = ?3 group by seat_row", nativeQuery = true)
	List<Integer> listSeatRow(String movieID, int showDateID, int scheduleID);
	
	@Query(value = "select * from Schedule_Seat where schedule_seat_id = ?1", nativeQuery = true)
	ScheduleSeat getScheduleSeatByID(int id);
	
	@Query(value = "SELECT ss.movieID, mv.movie_name_vn, ss.ticketID, COUNT(ss.movieID), sd.show_date FROM Schedule_Seat ss\r\n"
			+ "Join Movie mv on ss.movieID = mv.movie_id\r\n"
			+ "Join Show_Dates sd on ss.showDateID = sd.show_date_id\r\n"
			+ "WHERE ss.seat_status=1 and ss.movieID = ?1 \r\n"
			+ "Group by ss.movieID, ss.ticketID, sd.show_date, mv.movie_name_vn\r\n"
			,nativeQuery = true)
	List<Object[]> listThongkeSLV(String movieID);
	
	
}
