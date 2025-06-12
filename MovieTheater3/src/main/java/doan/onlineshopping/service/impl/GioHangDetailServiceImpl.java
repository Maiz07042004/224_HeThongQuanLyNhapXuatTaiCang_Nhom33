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
import doan.onlineshopping.entity.GioHang;
import doan.onlineshopping.entity.GioHangDetail;
import doan.onlineshopping.entity.GioHangID;
import doan.onlineshopping.entity.Product;
import doan.onlineshopping.repository.ICategoryRepository;
import doan.onlineshopping.repository.IGioHangDetailRepository;
import doan.onlineshopping.repository.IGioHangRepository;
import doan.onlineshopping.service.ICategoryService;
import doan.onlineshopping.service.IGioHangDetailService;
import doan.onlineshopping.service.IGioHangService;

@Service
public class GioHangDetailServiceImpl implements IGioHangDetailService {

	@Autowired
	private IGioHangDetailRepository GioHangDetailRepository;

	@Override
	public List<GioHangDetail> getListGioHangDetail() {
		return GioHangDetailRepository.findAll();
	}

	@Override
	public GioHangDetail getGioHangDetailById(GioHangID id) {
		return GioHangDetailRepository.findOne(id);
	}

	@Override
	public void addOrEditGioHangDetail(GioHangDetail giohangdetail) {
		GioHangDetailRepository.save(giohangdetail);
	}

	@Override
	public void deleteGioHangDetail(GioHangID id) {
		GioHangDetailRepository.delete(id);
	}

	public void updateQuantity(int productID, String accountID, int quantity) {
		GioHangDetailRepository.updateQuantity(productID, accountID, quantity);
	}
	
	public List<GioHangDetail> findProductByAccountID(String accountID) {
		return GioHangDetailRepository.findProductByAccountID(accountID);
	}

}
