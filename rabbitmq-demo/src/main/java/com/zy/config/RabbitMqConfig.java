package com.zy.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {
	/**
	 * 以下注释掉的内容可以在消费者里面用注解的形式创建  例如：
	 * @RabbitListener(bindings = @QueueBinding(
				value = @Queue(value = "order-queue", durable = "true"),
				exchange = @Exchange(name = "order-exchange" , durable = "true", type = "topic"),
				key = "order.routingKey1"
			)
		)
	 */
	
	
//	/**
//	 * 创建Queue， 也可以通过http://192.168.0.111:15672/#/exchanges来创建
//	 * 
//	 */
//	@Bean
//	public Queue orderQueue(){
//		return new Queue("order-queue");
//	}
//	
//	/**
//	 * 创建Exchange， 也可以通过http://192.168.0.111:15672/#/exchanges来创建
//	 * (Exchange 有4种类型：TopicExchange，FanoutExchange， DirectExchange, HeadersExchange)
//	 * 
//	 */
//	@Bean
//    TopicExchange orderExchange() {
//        return new TopicExchange("order-exchange");
//    }
//	
//	/**
//    * 将队列topic.message与exchange绑定，binding_key为topic.message,就是完全匹配
//    * @param queueMessage
//    * @param exchange
//    *@return
//    */
//   @Bean
//   Binding bindingOrderExchange(Queue orderQueue, TopicExchange orderExchange) {
////	   路由key可以是 : 
////	   		order.routingKey1(完全匹配) 
////	   		order.*(只匹配一个点后的。order.x.x就匹配不上了)
////	   		order.#(匹配多个点后的，范围更大 模糊匹配)
//       return BindingBuilder.bind(orderQueue).to(orderExchange).with("order.routingKey1");
//   }
}
