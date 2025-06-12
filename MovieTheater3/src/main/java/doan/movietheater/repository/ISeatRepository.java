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

import doan.movietheater.entity.Seat;

@Repository
public interface ISeatRepository extends JpaRepository<Seat, Integer> {
	@Query(value = "Delete FROM Seat WHERE cinemaRoomID = ?1", nativeQuery = true)
	Void deleteSeatRow(int roomID);
	
	@Query(value= "SELECT * FROM Seat WHERE cinemaRoomID=?1", nativeQuery = true)
	List<Seat> listSeatByRoomID(String roomID);
	
}
