package edu.mum.amqp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import edu.mum.domain.Item;
import edu.mum.domain.Order;
import edu.mum.domain.OrderItem;
import edu.mum.domain.OrderPayment;


public class AmqpItemServiceImpl implements AmqpItemService {
    public void publish(RabbitTemplate rabbitTemplate,String routeKey , Item item ) {

        rabbitTemplate.convertAndSend(routeKey,item);
        rabbitTemplate.convertAndSend("promotion.item.groupa",item);
        rabbitTemplate.convertAndSend("promotion.item.groupb",item);
         
    }
}
