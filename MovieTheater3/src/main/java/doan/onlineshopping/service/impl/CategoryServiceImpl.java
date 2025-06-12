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
import doan.onlineshopping.repository.ICategoryRepository;
import doan.onlineshopping.service.ICategoryService;

@Service
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	private ICategoryRepository CategoryRepository;

	@Override
	public List<Category> getListCategory() {
		return CategoryRepository.findAll();
	}

	@Override
	public Category getCategoryById(int id) {
		return CategoryRepository.findOne(id);
	}

	@Override
	public void addOrEditCategory(Category Category) {
		CategoryRepository.save(Category);
	}

	@Override
	public void deleteCategory(int id) {
		CategoryRepository.delete(id);
	}

}
