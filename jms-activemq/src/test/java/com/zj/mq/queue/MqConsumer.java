package com.zj.mq.queue;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * @Description: 消费者：队列模式
 * @author Jian Jang
 * @version 1.0 2017年9月5日
 */
public class MqConsumer {
	/**
	 * 服务地址
	 */
	private final static String URL = "tcp://192.168.11.225:61616";

	private final static String DESTINATION_QUEUE = "zjtest";

	public static void main(String[] args) throws Exception {
		// 1、创建连接工厂，JMS 用它创建连接
		// 构造ConnectionFactory实例对象
		/*
		 * ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
		 * ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD,
		 * URL);
		 */
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(URL);

		// 2、从连接工厂中获取连接
		// Connection ：JMS 客户端到JMS Provider 的连接
		Connection connection = connectionFactory.createConnection();
		// 3、启动连接
		connection.start();
		// 4、创建会话 Session： 一个发送或接收消息的线程
		Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
		// 5、创建消息目的地
		// Destination ：消息的目的地;消息在？
		Destination destination = session.createQueue(DESTINATION_QUEUE);
		// 6、创建消费者
		// MessageConsumer：消息接收者
		MessageConsumer consumer = session.createConsumer(destination);
		// 7、设置消息监听器
		consumer.setMessageListener(new MessageListener() {
			@Override
			public void onMessage(Message message) {
				TextMessage textMessage = (TextMessage) message;
				try {
					System.out.println("ActiveMq 接收到消息：" + textMessage.getText());
				} catch (JMSException e) {
					e.printStackTrace();
				}

			}
		});

	}

}
