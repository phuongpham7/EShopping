package edu.mum.amqp;

import java.util.Locale;

import edu.mum.domain.Item;
import edu.mum.emailservice.EmailSender;


public class AmqpItemListner {

	public void listen(Item item) {
			
		String name = item.getName();
		System.out.println("######################    SUBSCRIBER's  RECEIVED MESSAGE   ####################");
	     
		System.out.println("---------- TOPIC Promotion for Item: " + name);
		System.out.println("This chritmas lowest price : $ " +item.getPrice());
		String [] cc= {"efremtew@gmail.com","viethungqb0609@gmail.com"};
		EmailSender.sendEmail("Christmas Promotion ! " , "hardsujan@gmail.com", cc, null, item, "body.jpg", new Locale("en"));
	}
}
