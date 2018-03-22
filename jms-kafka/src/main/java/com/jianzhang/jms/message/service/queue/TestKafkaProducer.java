package com.jianzhang.jms.message.service.queue;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.jianzhang.jms.message.service.KafkaProducerService;

/**
 * @Description: kafka发送消息
 * @author Jian Jang
 * @version 1.0 2017年10月18日
 */
public class TestKafkaProducer {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("kafka-producer.xml");
		KafkaProducerService pService = ac.getBean(KafkaSendMessageServiceImpl.class);
		System.out.println(pService);
		pService.sendMessage("test2222");
		// 关闭上下文
		ac.close();
	}

}
