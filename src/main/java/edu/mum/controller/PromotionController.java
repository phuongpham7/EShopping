package edu.mum.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.domain.Item;
import edu.mum.service.ItemService;

@Controller
@RequestMapping({"/promotion"}) 
public class PromotionController {
	
	@Autowired
	private ItemService itemService;
 
	
	@RequestMapping(value = "/publish", method = RequestMethod.GET)
	public String getAddNewItemForm(@ModelAttribute("newItem") Item newItem) {
	   return "addPromotion";
	}
	   
	@RequestMapping(value = "/publish", method = RequestMethod.POST)
	public String processAddNewItemForm(@ModelAttribute("newItem") @Valid Item newItem, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "addPromotion";
		}

 		try {
			itemService.publish(newItem);
		} catch (Exception up) {
	      System.out.println("Transaction Failed!!! /n"+ up.getMessage());
 
		}
 		model.addAttribute("publishedItem", newItem);
	   	return "promotion";
	}
	
   
}
