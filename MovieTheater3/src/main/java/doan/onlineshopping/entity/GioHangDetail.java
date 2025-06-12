/*	
*	(C) Copyright 2024 Fresher56. All Rights Reserved
*
* @author ADMIN
* @date May 21, 2024
 
*/

package doan.onlineshopping.entity;

import java.io.Serializable;
import java.time.LocalDate;

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "GioHang_Detail")
@Where(clause = "delete_flag <> 1")
public class GioHangDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "Product", column = @Column(name = "product_id", length = 10)),
			@AttributeOverride(name = "Account", column = @Column(name = "account_id")) })
	private GioHangID gioHangID;


	@Column(name = "date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate Date;

	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "delete_flag")
	private int deleteFlag;
	public GioHangDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GioHangDetail(GioHangID gioHangID, LocalDate date, int quantity, int deleteFlag) {
		super();
		this.gioHangID = gioHangID;
		this.Date = date;
		this.quantity = quantity;
		this.deleteFlag = deleteFlag;
	}
	public GioHangID getGioHangID() {
		return gioHangID;
	}
	public void setGioHangID(GioHangID gioHangID) {
		this.gioHangID = gioHangID;
	}
	public LocalDate getDate() {
		return Date;
	}
	public void setDate(LocalDate date) {
		this.Date = date;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
