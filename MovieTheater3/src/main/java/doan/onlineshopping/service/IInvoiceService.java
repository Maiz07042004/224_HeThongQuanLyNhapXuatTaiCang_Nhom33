/*
 * (C) Copyright 2019 Fresher Academy. All Rights Reserved 
 *
 *	@author HCD-Fresher009
 *	@date Oct 18, 2019
 *	@version 1.0
 */

package doan.onlineshopping.service;

import java.util.List;

import doan.onlineshopping.entity.Category;
import doan.onlineshopping.entity.Invoice;
import doan.onlineshopping.entity.InvoiceDetail;
import doan.onlineshopping.entity.Product;

public interface IInvoiceService {
	public List<Invoice> getListInvoice();

	public Invoice getInvoiceById(int id);

	public void addOrEditInvoice(Invoice computer);

	public void deleteInvoice(int id);
	
	public List<Invoice> getInvoiceByBuyerID(String id);
	
	public List<Invoice> getInvoiceBySellerID(String id);
	
	public void updateInvoiceStatus(int invoiceID);
	
	public void updateInvoiceStatusSeller(int invoiceID);
	
	public List<Invoice> getInvoiceByMonth(String id);
}
