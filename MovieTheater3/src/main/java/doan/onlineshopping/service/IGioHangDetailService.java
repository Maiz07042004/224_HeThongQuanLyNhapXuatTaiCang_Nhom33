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
import doan.onlineshopping.entity.GioHangDetail;
import doan.onlineshopping.entity.GioHangID;
import doan.onlineshopping.entity.Product;

public interface IGioHangDetailService {
	public List<GioHangDetail> getListGioHangDetail();

	public GioHangDetail getGioHangDetailById(GioHangID id);

	public void addOrEditGioHangDetail(GioHangDetail giohangdetail);

	public void updateQuantity(int productID, String accountID, int quantity);

	public void deleteGioHangDetail(GioHangID id);
}
