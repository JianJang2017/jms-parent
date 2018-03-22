package com.jianzhang.jms.message.service;

/**
 * @Description: 消息发送接口
 * @author Jian Jang
 * @version 1.0 2017年10月18日
 */
public interface KafkaProducerService {
	/**
	 * @param message
	 */
	void sendMessage(String message);
}
