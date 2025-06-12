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
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Invoice_Detail")
@Where(clause = "delete_flag <> 1")
public class InvoiceDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "Product", column = @Column(name = "product_id", length = 10)),
			@AttributeOverride(name = "Invoice", column = @Column(name = "invoice_id")) })
	private InvoiceDetailId id;

	@Column(name = "delete_flag")
	private int deleteFlag;


	@Column(name = "soLuongMua")
	private int soLuongMua;


	public InvoiceDetail() {
		super();
		// TODO Auto-generated constructor stub
	}


	public InvoiceDetail(InvoiceDetailId id, int deleteFlag, int soLuongMua) {
		super();
		this.id = id;
		this.deleteFlag = deleteFlag;
		this.soLuongMua = soLuongMua;
	}


	public InvoiceDetailId getId() {
		return id;
	}


	public void setId(InvoiceDetailId id) {
		this.id = id;
	}


	public int getDeleteFlag() {
		return deleteFlag;
	}


	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}


	public int getSoLuongMua() {
		return soLuongMua;
	}


	public void setSoLuongMua(int soLuongMua) {
		this.soLuongMua = soLuongMua;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}



}