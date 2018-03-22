package com.zj.mq.cluster;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * @Description: 消息生产者：队列模式
 * @author Jian Jang
 * @version 1.0 2017年9月5日
 */
public class MqProducer {
	/**
	 * 服务地址:负载均衡
	 */
	private final static String URL = "failover:(tcp://192.168.11.224:61616,tcp://192.168.11.225:61616)?randomize=true";
	//高可用 HA
	//private final static String URL = "failover:(tcp://192.168.11.216:61616,tcp://192.168.11.224:61616,tcp://192.168.11.225:61616)?initialReconnectDelay=1000";

	private final static String DESTINATION_QUEUE = "queue-cluster";

	public static void main(String[] args) throws Exception {
		// 1、创建连接工厂，JMS 用它创建连接
		// 构造ConnectionFactory实例对象，此处采用ActiveMq的实现jar
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
		Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
		// 5、创建消息目的地
		// Destination ：消息的目的地;消息发送给谁.
		Destination destination = session.createQueue(DESTINATION_QUEUE);
		// 6、创建生产者
		// MessageProducer：消息发送者
		MessageProducer producer = session.createProducer(destination);
		// 设置不持久化，此处学习，实际根据项目决定
		producer.setDeliveryMode(DeliveryMode.PERSISTENT);
		sendMessage(session, producer);
		// TextMessage message;
		session.commit();
		// 关闭会话
		session.close();
		// 关闭连接
		connection.close();
	}

	public static void sendMessage(Session session, MessageProducer producer) throws Exception {
	  long start = System.currentTimeMillis();
		for (int i = 1; i <= 100; i++) {
			TextMessage message = session.createTextMessage("ActiveMq 队列模式发送的消息" + i);
			// 发送消息到目的地方
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"->发送消息：" + "ActiveMq 发送的消息" + i);
			producer.send(message);
		}
		long end = System.currentTimeMillis();
		System.out.println("共耗时："+(end-start)/1000+"秒");
	}
}
