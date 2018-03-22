package com.jianzhang.jms.message.service.topic;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jianzhang.jms.message.service.ProducerService;

/**
 * @Description: 测试类
 * @author Jian Jang
 * @version 1.0 2017年9月5日
 */
public class TestJmsTopic {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("topic-producer.xml");
		ProducerService pService = ac.getBean(ProducerServiceImpl.class);
		for (int i = 0; i < 100; i++) {
			pService.sendMessage("消息：" + i);
		}
		// 关闭上下文
		ac.close();
	}
}
