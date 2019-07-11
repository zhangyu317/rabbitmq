package com.zy.rabbit;
/**
 * 生产者
 */
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zy.entity.Order;

@Component
public class OrderSender {
	@Autowired
    private RabbitTemplate rabbitTemplate;
	
	public void send(Order order) throws Exception{
		CorrelationData correlationData = new CorrelationData();
		correlationData.setId(order.getMessageId());
		rabbitTemplate.convertAndSend(
				"order-exchange", //exchange
				"order.routingKey1", //routingKey
				order,  //消息体内容
				correlationData); //correlationData 消息唯一ID
	}
}
