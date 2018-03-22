package com.jianzhang.jms.message.service.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.jianzhang.jms.message.service.KafkaProducerService;

/**
 * @Description: 消息发送接口实现类
 * @author Jian Jang
 * @version 1.0 2017年10月18日
 */
@Service
public class KafkaSendMessageServiceImpl implements KafkaProducerService {
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	@Override
	public void sendMessage(String message) {
		System.out.println(kafkaTemplate);
		for (int i = 0; i < 100; i++) {
			System.out.println("发送消息："+"Hello ," + message + ":" + i);
			kafkaTemplate.sendDefault("Hello ," + message + ":" + i);
		}

	}

}
