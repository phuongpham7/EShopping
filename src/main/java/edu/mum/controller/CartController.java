package edu.mum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.service.CartItemService;

@Controller
@RequestMapping("/shoppingcart")
public class CartController {

	@Autowired
	private CartItemService cartItemService;
	
	@RequestMapping("/cart")
	public String categories(Model model) {
		return "/user/cart";
	}
}
