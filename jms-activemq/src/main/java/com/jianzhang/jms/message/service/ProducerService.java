package com.jianzhang.jms.message.service;

import com.jianzhang.jms.message.model.Student;

/**
 * @Description: 生产者发送消息接口
 * @author Jian Jang
 * @version 1.0 2017年9月5日
 */
public interface ProducerService {
	/***
	 * 发送文本消息
	 * @param message
	 */
	public void sendMessage(String message);

	/**
	 * 发送序列号对象消息
	 * @param message
	 */
	public void sendMessage(Student message);

}
