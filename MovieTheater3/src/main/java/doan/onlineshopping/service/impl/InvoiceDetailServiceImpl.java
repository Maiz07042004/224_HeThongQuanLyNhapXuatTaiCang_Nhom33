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
import doan.onlineshopping.entity.InvoiceDetailId;
import doan.onlineshopping.repository.ICategoryRepository;
import doan.onlineshopping.repository.IInvoiceDetailRepository;
import doan.onlineshopping.repository.IInvoiceRepository;
import doan.onlineshopping.service.ICategoryService;
import doan.onlineshopping.service.IInvoiceDetailService;
import doan.onlineshopping.service.IInvoiceService;

@Service
public class InvoiceDetailServiceImpl implements IInvoiceDetailService {

	@Autowired
	private IInvoiceDetailRepository InvoiceDetailRepository;

	@Override
	public List<InvoiceDetail> getListInvoiceDetail() {
		return InvoiceDetailRepository.findAll();
	}

	@Override
	public InvoiceDetail getInvoiceDetailById(InvoiceDetailId id) {
		return InvoiceDetailRepository.findOne(id);
	}

	@Override
	public void addOrEditInvoiceDetail(InvoiceDetail InvoiceDetail) {
		InvoiceDetailRepository.save(InvoiceDetail);
	}

	@Override
	public void deleteInvoiceDetail(InvoiceDetailId id) {
		InvoiceDetailRepository.delete(id);
	}

}
