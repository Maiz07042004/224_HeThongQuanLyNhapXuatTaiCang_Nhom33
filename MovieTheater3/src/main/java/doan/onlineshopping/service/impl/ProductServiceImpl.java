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

import doan.onlineshopping.entity.Account;
import doan.onlineshopping.entity.Category;
import doan.onlineshopping.entity.Product;
import doan.onlineshopping.repository.ICategoryRepository;
import doan.onlineshopping.repository.IProductRepository;
import doan.onlineshopping.service.ICategoryService;
import doan.onlineshopping.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductRepository ProductRepository;

	@Override
	public List<Product> getListProduct() {
		return ProductRepository.findAll();
	}

	@Override
	public Product getProductById(int id) {
		return ProductRepository.findOne(id);
	}

	@Override
	public void addOrEditProduct(Product product) {
		ProductRepository.save(product);
	}

	@Override
	public void deleteProduct(int id) {
		ProductRepository.delete(id);
	}

	
	public Product getProductByProductName(String productName) {
		return ProductRepository.getProductByProductName(productName);
	}
	
	public void updateQuantity(int sl, int productid) {
		ProductRepository.updateQuantity(sl, productid);
	}
	
	public List<Product> findProductByGioHangDetail(String accountID) {
	return	ProductRepository.findProductByGioHangDetail(accountID);
	}
	
	public List<Product> getProductByCategoryID(int id) {
		return	ProductRepository.getProductByCategoryID(id);
		}
	
	public List<Product> getProductBySellerID(String id) {
		return	ProductRepository.getProductBySellerID(id);
		}
}
