package edu.mum.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import edu.mum.domain.Item;

public class AmqpPublisher {

	public static void publish(Item item){
	      ApplicationContext context = new GenericXmlApplicationContext("classpath:META-INF/spring/promotion-app-context.xml");
	      
	        
	     	String routeKey="promotion.item";
	     	//item=new Item("Leather Shoes", "DELUXE", 79);
	     	
	     	RabbitTemplate topicTemplate =  context.getBean("topicTemplate",RabbitTemplate.class);
	     	AmqpItemService orderService = new AmqpItemServiceImpl();
	     	
	     	orderService.publish(topicTemplate,routeKey, item);
	     	System.out.println("######################    AMPQ PUBLISHER MESSAGE   ####################");
	     	System.out.println("Item "+item.getName()+" is published on route "+routeKey);
	     	
	     	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
	}
}
