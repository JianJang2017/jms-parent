package com.jianzhang.jms.message.service.queue;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jianzhang.jms.message.service.RabbitMqProducerService;

/**
 * @Description: 消息发送测试 
 * @author Jian Jang
 * @version 1.0 2018年3月28日
 */
public class TestRabbitMqProducer {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("rabbitmq-producer.xml");
		RabbitMqProducerService pService = (RabbitMqProducerService) ac.getBean("RabbitMqProducerService");
		pService.sendMessage("测试");
		ac.close();
	
	}

}
