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
	
		public static void sendEmail( final String recipientName, final String recipientEmail, final String [] ccrecipientEmail,  Order order,Item item, String documentName,final Locale locale)  
		{
	     ApplicationContext context = new ClassPathXmlApplicationContext("context/applicationContext.xml");

	    
	    EmailService emailService = (EmailService) context.getBean("emailService");
	    try {
			emailService.sendOrderReceivedMail(recipientName, recipientEmail,ccrecipientEmail,order,item, documentName,locale);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	    System.out.println("                      The Email is on the WAY!!!");


	}

}
