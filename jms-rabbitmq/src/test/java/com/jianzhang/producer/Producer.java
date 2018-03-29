/**
 * Copyright 2018 by FREEMYPAL. Tianhua Information Technology Park (South) Building 4, 4th Floor, 
 * Longtian Road 195,Shanghai, P.R. China，200235. All rights reserved.
 *
 * This software is the confidential and proprietary information of FREEMYPAL
 * ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into with FREEMYPAL.
 */
package com.jianzhang.producer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @Description: (这里用一句话描述这个类的作用)  
 * @author Jian Jang
 * @version 1.0 2018年3月28日
 */
public class Producer {
	private final static String QUEUE_NAME = "hello";
	private final static String HOST = "192.168.127.128:5672";

	  public static void main(String[] argv) throws Exception {
	                
	    ConnectionFactory factory = new ConnectionFactory();
	    factory.setHost(HOST);
	    Connection connection = factory.newConnection();
	    Channel channel = connection.createChannel();

	    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
	    String message = "Hello World!";
	    channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
	    System.out.println(" [x] Sent '" + message + "'");
	    
	    channel.close();
	    connection.close();
	  }
}
