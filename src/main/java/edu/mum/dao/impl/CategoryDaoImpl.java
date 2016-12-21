package edu.mum.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.dao.CategoryDao;
import edu.mum.domain.Category;
import edu.mum.domain.Item;

@SuppressWarnings("unchecked")
@Repository
public class CategoryDaoImpl extends GenericDaoImpl<Category> implements CategoryDao {

	public CategoryDaoImpl() {
		super.setDaoType(Category.class);
	}
	
	@Override
	public List<Item> findProductByCategoryId(Long categoryId) {
		Query query = entityManager.createQuery("select i from Category c, Item i, Category_Item ci "
				+ "where c.id = :categoryId AND "
				+ "		 c.id = ci.category_ID AND "
				+ "		 ci.item_ID = i.id");
		
		return (List<Item>) query.setParameter("categoryId", categoryId).getResultList();
	}

	@Override
	public List<Item> findProductByCategoryName(String categoryName) {
		Query query = entityManager.createQuery("select i from Category c, Item i, Category_Item ci "
				+ "where c.name = :categoryName AND "
				+ "		 c.id = ci.category_ID AND "
				+ "		 ci.item_ID = i.id");
		
		return (List<Item>) query.setParameter("categoryName", categoryName).getResultList();
	}
}
