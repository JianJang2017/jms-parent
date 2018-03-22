package com.jianzhang.jms.message.service.queue;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: kafka消费消息
 * @author Jian Jang
 * @version 1.0 2017年10月18日
 */
public class TestKafkaConsumer {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("kafka-consumer.xml");
	}

}
