package edu.mum.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.mum.domain.Item;

 

public interface ProductRepositoryLite {

	List <Item> getAllProducts();
	
	Item getProductById(String key);
	
	List<Item> getProductsByCategory(String category);

	Set<Item> getProductsByFilter(Map<String, List<String>> filterParams);
	
	void addProduct(Item product);		
}
