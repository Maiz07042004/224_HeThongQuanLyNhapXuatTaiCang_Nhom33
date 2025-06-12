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
import doan.onlineshopping.entity.Product;

public interface IProductService {
	public List<Product> getListProduct();

	public Product getProductById(int id);

	public void addOrEditProduct(Product computer);

	public void deleteProduct(int id);

	public Product getProductByProductName(String productName) ;
	
	public void updateQuantity(int sl, int productid);
	
	public List<Product> getProductByCategoryID(int id) ;
	
	public List<Product> getProductBySellerID(String id) ;


}
