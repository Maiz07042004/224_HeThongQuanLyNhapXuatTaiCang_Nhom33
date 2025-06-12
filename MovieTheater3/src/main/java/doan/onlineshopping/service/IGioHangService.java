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
import doan.onlineshopping.entity.GioHang;
import doan.onlineshopping.entity.Product;

public interface IGioHangService {
	public List<GioHang> getListGioHang();

	public GioHang getGioHangById(int id);

	public void addOrEditGioHang(GioHang giohang);

	public void deleteGioHang(int id);
}
