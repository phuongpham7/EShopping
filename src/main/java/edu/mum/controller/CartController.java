package edu.mum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.domain.Item;
import edu.mum.service.CartItemService;

@Controller
@RequestMapping("/shoppingcart")
public class CartController {

	@Autowired
	private CartItemService cartItemService;
	
	@RequestMapping("/cart")
	public String categories(Model model) {
		List<Item> items = cartItemService.getAllItemsByUserId(new Long(2));
		
		if (items != null && items.size() > 0)
			model.addAttribute("items", items);

		return "/user/cart";
	}
	
	@RequestMapping("/processOrder")
	public String processOrder(Model model) {
		List<Item> items = cartItemService.getAllItemsByUserId(new Long(2));
		
		
		
		return "/user/confirmation";
	}
}
