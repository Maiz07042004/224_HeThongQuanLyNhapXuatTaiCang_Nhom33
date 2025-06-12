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
public class InvoiceDetailId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "InvoiceID")
	private int invoiceID;

	@Column(name = "ProductID")
	private int productID;

	public InvoiceDetailId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvoiceDetailId(int invoiceID, int productID) {
		super();
		this.invoiceID = invoiceID;
		this.productID = productID;
	}

	public int getInvoiceID() {
		return invoiceID;
	}

	public void setInvoiceID(int invoiceID) {
		this.invoiceID = invoiceID;
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
