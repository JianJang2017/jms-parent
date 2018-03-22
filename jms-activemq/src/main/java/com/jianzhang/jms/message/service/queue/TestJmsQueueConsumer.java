package com.jianzhang.jms.message.service.queue;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: 测试类
 * @author Jian Jang
 * @version 1.0 2017年9月5日
 */
public class TestJmsQueueConsumer {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("queue-consumer.xml");
		// 关闭上下文
		//ac.close();
	}
}
