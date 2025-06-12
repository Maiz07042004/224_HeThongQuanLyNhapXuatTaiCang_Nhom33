/*	
*	(C) Copyright 2024 Fresher56. All Rights Reserved
*
* @author ADMIN
* @date May 22, 2024
 
*/

package doan.onlineshopping.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Where;


@Entity
@Table(name = "GioHang")
@Where(clause = "delete_flag <> 1")
public class GioHang implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "giohang_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int gioHangID;

	@Column(name = "account_id", length = 255)
	private String accountId;

	public GioHang(int gioHangID, String accountId) {
		super();
		this.gioHangID = gioHangID;
		this.accountId = accountId;
	}

	public GioHang() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getGioHangID() {
		return gioHangID;
	}

	public void setGioHangID(int gioHangID) {
		this.gioHangID = gioHangID;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
