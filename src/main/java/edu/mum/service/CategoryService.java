package edu.mum.service;

import java.util.List;

import edu.mum.domain.Category;

public interface CategoryService {

	public List<Category> getCategoryList();
	public Category findOne(Long id);
}
