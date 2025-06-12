/*
 * (C) Copyright 2019 Fresher Academy. All Rights Reserved 
 *
 *	@author HCD-Fresher009
 *	@date Oct 18, 2019
 *	@version 1.0
 */

package doan.movietheater.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "Ticket")
@SQLDelete(sql = "update Ticket set delete_flag = 1 where ticket_id = ?")
@Where(clause = "delete_flag <> 1")
public class Ticket implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ticket_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ticketID;

	@Column(name = "price")
	private int price;

	@Column(name = "ticket_type")
	private int ticketType;

	@Column(name = "delete_flag")
	private int deleteFlag;

	@OneToMany(mappedBy = "ticket", fetch = FetchType.LAZY)
	private List<ScheduleSeat> listScheduleSeat;

	public Ticket() {
		super();
	}

	public Ticket(int ticketID, int price, int ticketType, int deleteFlag) {
		super();
		this.ticketID = ticketID;
		this.price = price;
		this.ticketType = ticketType;
		this.deleteFlag = deleteFlag;
	}

	public int getTicketID() {
		return ticketID;
	}

	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getTicketType() {
		return ticketType;
	}

	public void setTicketType(int ticketType) {
		this.ticketType = ticketType;
	}

	public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public List<ScheduleSeat> getListScheduleSeat() {
		return listScheduleSeat;
	}

	public void setListScheduleSeat(List<ScheduleSeat> listScheduleSeat) {
		this.listScheduleSeat = listScheduleSeat;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
