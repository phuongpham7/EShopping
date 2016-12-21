package edu.mum.dao.impl;

import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import edu.mum.domain.Item;
import edu.mum.dao.ItemDao;

@SuppressWarnings("unchecked")
@Repository
public class ItemDaoImpl extends GenericDaoImpl<Item> implements ItemDao {

	public ItemDaoImpl() {
		super.setDaoType(Item.class);
	}

	@Override
	public Item findOne(Long itemId) {
		Query query = entityManager.createQuery("select i from item i where i.id = :itemId");
		return (Item) query.setParameter("itemId", itemId).getSingleResult();
	}

	@Override
	public List<Item> findItemByName(String itemName) {
		Query query = entityManager.createQuery("select i from item i where i.id = %:itemId%");
		return (List<Item>) query.setParameter("itemId", itemName).getResultList();
	}

}
