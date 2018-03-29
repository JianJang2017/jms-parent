package com.jianzhang.jms.message.service.queue;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jianzhang.jms.message.service.RabbitMqProducerService;

/**
 * @Description: 消息发送实现类
 * 参考文档：https://docs.spring.io/spring-amqp/docs/1.7.1.RELEASE/reference/htmlsingle/
 * @author Jian Jang
 * @version 1.0 2018年3月28日
 */
@Service("RabbitMqProducerService")
public class RabbitMqProducerServiceImpl implements RabbitMqProducerService {
	Logger logger =Logger.getLogger(this.getClass());
	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Override
	public void sendMessage(String message) {
		logger.info("发送消息：" +message);
		rabbitTemplate.convertAndSend("myExchange", "foo.bar", "Hello," + message);
	}

}
