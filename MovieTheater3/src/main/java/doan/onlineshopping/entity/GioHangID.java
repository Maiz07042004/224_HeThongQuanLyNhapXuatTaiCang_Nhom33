/*
 * (C) Copyright 2019 Fresher Academy. All Rights Reserved 
 *
 *	@author HCD-Fresher009
 *	@date Oct 18, 2019
 *	@version 1.0
 */

package doan.onlineshopping.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class GioHangID implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "account_ID")
	private String accountID;

	@Column(name = "ProductID")
	private int productID;

	public GioHangID(String accountID, int productID) {
		super();
		this.accountID = accountID;
		this.productID = productID;
	}

	public GioHangID() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
}