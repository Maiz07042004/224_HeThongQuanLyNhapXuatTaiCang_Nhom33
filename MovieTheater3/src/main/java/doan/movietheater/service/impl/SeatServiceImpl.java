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

import doan.movietheater.entity.Seat;
import doan.movietheater.repository.ISeatRepository;
import doan.movietheater.service.ISeatService;

@Service
public class SeatServiceImpl implements ISeatService {

	@Autowired
	ISeatRepository seatRepository;

	@Override
	public List<Seat> getListSeat() {
		return seatRepository.findAll();
	}

	@Override
	public Seat getSeatById(int id) {
		return seatRepository.findOne(id);
	}

	@Override
	public void addOrEditSeat(Seat seat) {
		seatRepository.save(seat);
	}

	@Override
	public void deleteSeat(int id) {
		seatRepository.delete(id);
	}

	@Override
	public void deleteSeatRow(int roomID) {
		seatRepository.deleteSeatRow(roomID);
	}
	
	public List<Seat> listSeatByRoomID(String roomID){
		return seatRepository.listSeatByRoomID(roomID);
	}
	
}
