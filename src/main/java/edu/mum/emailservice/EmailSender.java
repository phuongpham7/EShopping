package edu.mum.emailservice;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import javax.mail.MessagingException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.mum.domain.Item;
import edu.mum.domain.Order;
import edu.mum.domain.OrderItem;
import edu.mum.domain.OrderPayment;
import edu.mum.domain.User;

public class EmailSender {
	
	public static void sendEmail(User user){
		 ApplicationContext context = new ClassPathXmlApplicationContext("context/applicationContext.xml");

		    Item item = new Item("Alarm Clock", "Simple & Automatic", 79);
		    OrderPayment orderPayment = new OrderPayment();
		    OrderItem orderItem = new OrderItem(2, item);
		    Set<OrderItem> orderItems = new HashSet<OrderItem>();
		    orderItems.add(orderItem);
		    Order order = new Order("B123",orderItems,orderPayment);
		    
		    String documentName = "AlarmClock.docx";
		    EmailService emailService = (EmailService) context.getBean("emailService");
		    try {
				emailService.sendOrderReceivedMail(user.getFirstName(), "hardsujan@gmail.com",order,documentName,new Locale("en"));
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		    System.out.println("                      The Email is on the WAY!!!");
	}

}
