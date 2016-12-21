package edu.mum.dao;

import java.util.List;

import edu.mum.domain.Category;
import edu.mum.domain.Item;

public interface CategoryDao extends GenericDao<Category>{
	List<Item> findProductByCategoryId(Long categoryId);
	List<Item> findProductByCategoryName(String categoryName);
}
