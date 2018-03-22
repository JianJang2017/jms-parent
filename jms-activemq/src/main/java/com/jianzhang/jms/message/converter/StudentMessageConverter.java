package com.jianzhang.jms.message.converter;

import java.io.Serializable;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQObjectMessage;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

import com.jianzhang.jms.message.model.Student;

/**
 * @Description: 自定义消息转化器
 * @author Jian Jang
 * @version 1.0 2017年11月12日
 */
public class StudentMessageConverter implements MessageConverter {

	/**
	 * Listener接收消息的时候调用
	 */
	@Override
	public Object fromMessage(Message message) throws JMSException, MessageConversionException {
		Student student = null;
		if (message instanceof ActiveMQObjectMessage) {
			ActiveMQObjectMessage aMsg = (ActiveMQObjectMessage) message;
			student = (Student) aMsg.getObject();
			return student;
		} else {
			// 否则返回对象本身
			return message;
		}
	}

	/**
	 * 调用converterAndSend方法的时候调用
	 */
	@Override
	public Message toMessage(Object object, Session session) throws JMSException,
			MessageConversionException {
		System.out.println("发送时消息转换:{}" + object.toString());
		ActiveMQObjectMessage msg = (ActiveMQObjectMessage) session.createObjectMessage();
		msg.setObject((Serializable) object);
		return msg;

	}

}
