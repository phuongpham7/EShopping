package edu.mum.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import edu.mum.domain.Category;
import edu.mum.domain.Item;
import edu.mum.service.CategoryService;
import edu.mum.service.ItemService;

@Controller
@RequestMapping("/admin") // map items.jsp request to ItemController class
public class ItemController {

	@Autowired
	private ItemService itemService;

	@Autowired
	private CategoryService categoryService;

	@RequestMapping("/item")
	public String items(Model model) {
		List<Item> items = itemService.getAllItems();
		model.addAttribute("items", items);
		return "admin/item";
	}

	@RequestMapping("/addItem")
	public String categories(Model model) {
		List<Category> categories = categoryService.getCategoryList();
		model.addAttribute("categories", categories);
		return "admin/addItem";
	}

	Path path;

	@RequestMapping(value = "/addNewItem", method = RequestMethod.POST)
	public String addItem(@Valid @ModelAttribute("item") Item item, BindingResult result, HttpServletRequest request)
			throws IllegalStateException, IOException {
		if (result.hasErrors()) {
			System.out.println("errorrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
			return "admin/addNewItem";
		}

		Set<Category> categories = new HashSet<Category>();
		String[] categoryIds = request.getParameterValues("category");
		for (String categoryId : categoryIds) {
			Category cat = categoryService.findOne(Long.parseLong(categoryId));
			categories.add(cat);
			cat.addItem(item);
		}

		item.setCategories(categories);

		itemService.save(item);

		MultipartFile image = item.getItemImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "\\resources\\images\\items\\" + item.getItemId() + ".png");

		if (image != null && !image.isEmpty()) {
			image.transferTo(new File(path.toString()));
		}

		return "redirect:/admin/item";
	}

	// @RequestMapping({"","/all"})
	// public String list(Model model) {
	// model.addAttribute("items", itemService.getAllItems());
	// return "items";
	// }
	//
	//
	//
	// @RequestMapping("/item")
	// public String getProductById(Model model, @RequestParam("id") Long id) {
	//
	// Item item = itemService.findOne(id);
	// model.addAttribute("item", item);
	// return "item";
	// }
	//
	//
	// @RequestMapping(value = "/add", method = RequestMethod.GET)
	// public String getAddNewItemForm(@ModelAttribute("newItem") Item newItem)
	// {
	// return "addItem";
	// }
	//
	// @RequestMapping(value = "/add", method = RequestMethod.POST)
	// public String processAddNewItemForm(@ModelAttribute("newItem") @Valid
	// Item itemToBeAdded, BindingResult result) {
	// if(result.hasErrors()) {
	// return "addItem";
	// }
	//
	// try {
	// itemService.save(itemToBeAdded);
	// } catch (Exception up) {
	// System.out.println("Transaction Failed!!!");
	//
	// }
	//
	// return "redirect:/items";
	// }

}
