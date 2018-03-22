package com.jianzhang.jms.message.service.topic;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @Description: 消费者监听:
 * @author Jian Jang
 * @version 1.0 2017年9月5日
 */
public class ConsumerMessageListener implements MessageListener {

	@Override
	public void onMessage(Message message) {
		TextMessage textMessage = (TextMessage) message;
		try {
			System.out.println("接收到消息：" + textMessage.getText());
			//消息解析进行其他业务处理 TODO
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
