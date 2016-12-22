package edu.mum.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import edu.mum.domain.Item;
import edu.mum.domain.Order;

public interface AmqpItemService {
    public void publish(RabbitTemplate rabbitTemplate,String routeKey , Item item );
}
