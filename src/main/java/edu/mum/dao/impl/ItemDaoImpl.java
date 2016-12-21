package edu.mum.dao.impl;


import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.domain.User;
import edu.mum.domain.Item;

import edu.mum.dao.ItemDao;

	@Repository
	public class ItemDaoImpl extends GenericDaoImpl<Item> implements ItemDao
	{
		
		public ItemDaoImpl() {
			super.setDaoType(Item.class );
			}


  
	}

