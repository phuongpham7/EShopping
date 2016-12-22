package edu.mum.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.domain.Item;
import edu.mum.domain.Order;
import edu.mum.domain.OrderItem;
import edu.mum.domain.OrderPayment;
import edu.mum.domain.User;
import edu.mum.emailservice.EmailSender;
import edu.mum.service.UserService;

@Controller
@RequestMapping({"/users"})
public class UserController {
	
	@Autowired
	private UserService  userService;

	@RequestMapping
	public String listMembers(Model model) {
		model.addAttribute("users", userService.findAll());
		return "users";
	}
	   
  	@RequestMapping("/{id}")
	public String getMemberById(@PathVariable("id") Long id,Model model) {
		User member = userService.findOne(id);
		model.addAttribute("user", member);

 		return "user";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewMemberForm(@ModelAttribute("newUser") User newUser) {
	   return "addUser";
	}
	   
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewMemberForm(@ModelAttribute("newUser") @Valid User userToBeAdded, BindingResult result) {
 
		if(result.hasErrors()) {
			return "addUser";
		}

			 //  Error caught by ControllerAdvice IF no authorization...
			userService.saveFull(userToBeAdded);

	   	return "redirect:/users";
 
	}
	
	@RequestMapping("/{id}/email")
	public String sendEmail(@PathVariable("id") Long id,Model model) {
		User user = userService.findOne(id);
		//Order oder = user.getOrders().get(0);
		
		    Item item = new Item("Alarm Clock", "Simple & Automatic", 79);
		    OrderPayment orderPayment = new OrderPayment();
		    OrderItem orderItem = new OrderItem(2, item);
		    List<OrderItem> orderItems = new ArrayList<OrderItem>();
		    orderItems.add(orderItem);
		    Order order = new Order("B123",orderItems,orderPayment);
		    
		    String documentName = "sale.jpg";
		    userService.sendEmail(user.getFirstName(), "hardsujan@gmail.com", null, order , item, documentName, new Locale("en"));

		//model.addAttribute("order", order);
 		return "email";
	}
}
