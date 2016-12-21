package edu.mum.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
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
import org.springframework.web.bind.annotation.PathVariable;
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
//		if (result.hasErrors()) {
//			System.out.println("errorrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
//			return "admin/addItem";
//		}

		String categoryId = request.getParameter("category");
		Category cat = categoryService.findOne(Long.parseLong(categoryId));
		cat.addItem(item);
		item.setCategory(cat);
		
		itemService.save(item);

		MultipartFile image = item.getItemImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "\\resources\\images\\items\\" + item.getItemId() + ".png");

		if (image != null && !image.isEmpty()) {
			image.transferTo(new File(path.toString()));
		}

		return "redirect:/admin/item";
	}
	
	@RequestMapping("/editItem/{id}")
	public String editItem(@PathVariable int id, Model model) {
		
		Item item = itemService.findOne(id);
		
		model.addAttribute(item);
		List<Category> categories = categoryService.getCategoryList();
		model.addAttribute("categories", categories);
		return "admin/editItem";
	}
	
	@RequestMapping(value = "/editItem", method = RequestMethod.POST)
	public String editItemPost(@Valid @ModelAttribute("item") Item item,BindingResult result, Model model, HttpServletRequest request) {
//		if (result.hasErrors()){
//			return "admin/editItem";
//		}
		
		MultipartFile itemImage = item.getItemImage();

		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "\\resources\\images\\" + item.getItemId() + ".png");
		if (itemImage != null && !itemImage.isEmpty()) {

			try {
				itemImage.transferTo(new File(path.toString()));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		itemService.save(item);

		return "redirect:/admin/item";
	}

	@RequestMapping("/deleteItem/{id}")
	public String deleteItem(@PathVariable Long id, Model model, HttpServletRequest request) {
		Item item = itemService.findOne(id);
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "\\resources\\images\\" + item.getItemId() + ".png");

		if (Files.exists(path)) {
			try {
				Files.delete(path);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		itemService.deleteItem(id);
		return "redirect:/admin/item";
	}
}
