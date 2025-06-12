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
import doan.onlineshopping.repository.ICategoryRepository;
import doan.onlineshopping.repository.IGioHangRepository;
import doan.onlineshopping.service.ICategoryService;
import doan.onlineshopping.service.IGioHangService;

@Service
public class GioHangServiceImpl implements IGioHangService {

	@Autowired
	private IGioHangRepository GioHangRepository;

	@Override
	public List<GioHang> getListGioHang() {
		return GioHangRepository.findAll();
	}

	@Override
	public GioHang getGioHangById(int id) {
		return GioHangRepository.findOne(id);
	}

	@Override
	public void addOrEditGioHang(GioHang giohang) {
		GioHangRepository.save(giohang);
	}

	@Override
	public void deleteGioHang(int id) {
		GioHangRepository.delete(id);
	}

}
