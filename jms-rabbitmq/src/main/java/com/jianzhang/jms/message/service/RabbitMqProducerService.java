package com.jianzhang.jms.message.service;

/**
 * @Description: 消息发送服务接口
 * @author Jian Jang
 * @version 1.0 2018年3月28日
 */
public interface RabbitMqProducerService {
	/**
	 * @param message
	 */
	void sendMessage(String message);
}
