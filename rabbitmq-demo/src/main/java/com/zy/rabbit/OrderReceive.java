package com.zy.rabbit;
import java.io.IOException;
import java.util.Map;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;
import com.zy.entity.Order;
/**
 * 消费者
 * @author ZhangY
 *
 */
@Component
public class OrderReceive {
	/**
	 * durable: 是否持久化
	 * @RabbitListener 该注解可以自动在mq中创建Queue Exchange 并建立绑定关系, 不需要在生产者创建bean config
	 */
	@RabbitListener(bindings = @QueueBinding(
				value = @Queue(value = "order-queue", durable = "true"),
				exchange = @Exchange(name = "order-exchange" , durable = "true", type = "topic"),
				key = "order.routingKey1"
			)
	)
	
	@RabbitHandler
	public void onOrderMessage(@Payload Order order,
			@Headers Map<String, Object> headers, 
			Channel channel //因为是手工签收，所以要定义channel
			) throws IOException {
		//消费操作
		System.out.println("----------收到消息，开始消费----------------");
		System.out.println("订单ID"+ order.getId());
		System.out.println("订单名称"+ order.getName());
		
		Long deliveryTag = (Long)headers.get(AmqpHeaders.DELIVERY_TAG);
		//ACK 因为是手工签收，所以要主动给mq回送一个相应告诉mq消息处理完了，让mq删除掉这条message.
		//如果注释掉，mq管理中就会出现Unacked
		channel.basicAck(deliveryTag, false);//multiple：是否支持批量签收
	}
}
