package com.zy.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zy.entity.Order;
import com.zy.rabbit.OrderSender;

@RestController
@RequestMapping("/rabbit")
public class RabbitTest {
	
	@Autowired
	private OrderSender orderSender;
    
    @GetMapping("/testOrderSender")
    public void testOrderSender() throws Exception{
    	Order order = new Order();
    	order.setId("201906180000000001");
    	order.setName("测试订单1");
    	order.setMessageId(System.currentTimeMillis()+"$" + UUID.randomUUID().toString());
    	orderSender.send(order);
    }
}
