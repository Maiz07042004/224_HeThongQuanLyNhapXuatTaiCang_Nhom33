/*
 * (C) Copyright 2019 Fresher Academy. All Rights Reserved 
 *
 *	@author HCD-Fresher009
 *	@date Oct 18, 2019
 *	@version 1.0
 */

package doan.onlineshopping.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import doan.onlineshopping.entity.Category;
import doan.onlineshopping.entity.Invoice;
import doan.onlineshopping.entity.InvoiceDetail;
import doan.onlineshopping.repository.ICategoryRepository;
import doan.onlineshopping.repository.IInvoiceRepository;
import doan.onlineshopping.service.ICategoryService;
import doan.onlineshopping.service.IInvoiceService;

@Service
public class InvoiceServiceImpl implements IInvoiceService {

	@Autowired
	private IInvoiceRepository InvoiceRepository;

	@Override
	public List<Invoice> getListInvoice() {
		return InvoiceRepository.findAll();
	}

	@Override
	public Invoice getInvoiceById(int id) {
		return InvoiceRepository.findOne(id);
	}

	@Override
	public void addOrEditInvoice(Invoice Invoice) {
		InvoiceRepository.save(Invoice);
	}

	@Override
	public void deleteInvoice(int id) {
		InvoiceRepository.delete(id);
	}
	
	public Invoice getLatestInvoice() {
		return InvoiceRepository.getLatestInvoice();
	}

	public List<Invoice> getInvoiceByBuyerID(String id) {
		// TODO Auto-generated method stub
		return InvoiceRepository.getInvoiceByBuyerID(id);
	}
	
	public List<Invoice> getInvoiceBySellerID(String id) {
		// TODO Auto-generated method stub
		return InvoiceRepository.getInvoiceBySellerID(id);
	}
	
	public List<Invoice> getInvoiceByMonth(String id) {
		// TODO Auto-generated method stub
		return InvoiceRepository.getInvoiceByMonth(id);
	}
	
	public List<Invoice> getInvoiceByBuyer(String id) {
		// TODO Auto-generated method stub
		return InvoiceRepository.getInvoiceByBuyer(id);
	}
	
	public void updateInvoiceStatus(int invoiceID) {
		InvoiceRepository.updateInvoiceStatus(invoiceID);
	
	}
	
	public void updateInvoiceStatusSeller(int invoiceID) {
		InvoiceRepository.updateInvoiceStatusSeller(invoiceID);
	
	}
	
	public List<String> getBuyerBySellerID(String id){
		return InvoiceRepository.getBuyerBySellerID(id);
	}

	

	


}
