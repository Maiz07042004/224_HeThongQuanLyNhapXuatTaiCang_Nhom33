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
import doan.onlineshopping.entity.InvoiceDetailId;
import doan.onlineshopping.entity.Product;

public interface IInvoiceDetailService {
	public List<InvoiceDetail> getListInvoiceDetail();

	public InvoiceDetail getInvoiceDetailById(InvoiceDetailId id);

	public void addOrEditInvoiceDetail(InvoiceDetail computer);

	public void deleteInvoiceDetail(InvoiceDetailId id);
}
