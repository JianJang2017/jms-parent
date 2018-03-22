package com.jianzhang.jms.message.service.queue;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import com.jianzhang.jms.message.model.Student;
import com.jianzhang.jms.message.service.ProducerService;

/**
 * @Description: 消息发送：队列模式
 * @author Jian Jang
 * @version 1.0 2017年9月5日
 */
public class ProducerServiceImpl implements ProducerService {
	@Autowired
	private JmsTemplate jmsTemplate;
	@Resource(name = "queueDestination")
	private Destination destination;

	@Override
	public void sendMessage(final String message) {
		// 1、文本信息

		jmsTemplate.send(destination, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				System.out.println(destination.getClass().getSimpleName() + "开始发送消息：" + message);
				return session.createTextMessage(message);
			}
		});

	}

	@Override
	public void sendMessage(Student message) {
		System.out.println("发送学生信息："+message.toString());
		jmsTemplate.convertAndSend(destination, message);
	}
}
