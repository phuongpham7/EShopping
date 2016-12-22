package edu.mum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.domain.Item;
import edu.mum.service.ItemService;

@Controller
@RequestMapping("/product")
public class PurchaseController {
	@Autowired
	private ItemService itemService;
	
	//@Autowired
	//private ItemService itemService;
	
	@RequestMapping("/getProduct/{id}")
	public String productFromCategory(@PathVariable("id") Long id, Model model){
		  
		List<Item> items=itemService.findItemByCategoryId(id);
		model.addAttribute("items",items); 
		return "user/productList";	
	}
	   
	@RequestMapping("/addProductToCart/{id}")
	public String addProductToCart(@PathVariable("id") Long id, Model model){
		
		Item item=itemService.findOne(id);
		
		return "user/ProductAddedToCartConfirmation";
	}

}
