/*
 * (C) Copyright 2019 Fresher Academy. All Rights Reserved 
 *
 *	@author HCD-Fresher009
 *	@date Oct 18, 2019
 *	@version 1.0
 */

package doan.onlineshopping.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Invoice")
@Where(clause = "delete_flag <> 1")
public class Invoice implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	@Id
	@Column(name = "invoice_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int invoiceId;
	
	@Column(name = "delete_flag")
	private int deleteFlag;
	
	@Column(name = "buyer_id", length = 255)
	private String buyerId;

	@Column(name = "seller_id", length = 255)
	private String sellerId;

	@Column(name = "date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	
	@Column(name = "status", length = 255)
	private String status;

	public Invoice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Invoice(int invoiceId, int deleteFlag, String buyerId, String sellerId, LocalDate date, String status) {
		super();
		this.invoiceId = invoiceId;
		this.deleteFlag = deleteFlag;
		this.buyerId = buyerId;
		this.sellerId = sellerId;
		this.date = date;
		this.status = status;
	}

	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
