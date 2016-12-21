package edu.mum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.domain.Category;
import edu.mum.service.CategoryService;

@Controller
@RequestMapping("/admin")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	  
	@RequestMapping("/category")
	public String categories(Model model) {
		List<Category> categories = categoryService.getCategoryList();
		model.addAttribute("categories", categories);
		return "admin/category";
	}
	

}


