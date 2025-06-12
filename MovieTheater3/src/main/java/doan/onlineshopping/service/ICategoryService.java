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

public interface ICategoryService {
	public List<Category> getListCategory();

	public Category getCategoryById(int id);

	public void addOrEditCategory(Category computer);

	public void deleteCategory(int id);
}
