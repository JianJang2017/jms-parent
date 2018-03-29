package com.jianzhang.jms.message.service.queue;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: 消息接收测试 
 * @author Jian Jang
 * @version 1.0 2018年3月28日
 */
public class TestRabbitMqConsumer {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("rabbitmq-consumer.xml");
	}

}
