package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.CategoryDao;
import edu.mum.domain.Category;
import edu.mum.service.CategoryService;

@Service
@Transactional 
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public List<Category> getCategoryList() {
		return (List<Category>)categoryDao.findAll();
	}

	@Override
	public Category findOne(Long id) {
		return categoryDao.findOne(id);
	}

}
