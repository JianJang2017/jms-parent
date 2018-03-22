package com.jianzhang.jms.message.service.queue;

import javax.jms.JMSException;

import org.apache.activemq.command.ActiveMQTextMessage;

import com.jianzhang.jms.message.model.Student;

/**
 * @Description: 消息接受监听器
 * @author Jian Jang
 * @version 1.0 2017年11月12日
 */
public class StudentMessageListener {

	/**
	 * 接受序列化对象消息
	 * @param student
	 */
	public void receiveMessage(Student obj) {
		if(null!=obj){
			System.out.println("recieve Student:"+ obj.getName());
		}else{
			System.out.println("recieve Object:null");
		}
			
	}

	/**
	 * 接受纯文本消息
	 * @param message
	 * @throws JMSException 
	 */
	public void receiveMessage(ActiveMQTextMessage message) throws JMSException {
		System.out.println("recieve text:{}"+ message.getText());
	}
}
