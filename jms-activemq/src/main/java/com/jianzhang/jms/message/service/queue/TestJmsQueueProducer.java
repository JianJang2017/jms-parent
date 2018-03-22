package com.jianzhang.jms.message.service.queue;

import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jianzhang.jms.message.model.Student;
import com.jianzhang.jms.message.service.ProducerService;

/**
 * @Description: 测试类
 * @author Jian Jang
 * @version 1.0 2017年9月5日
 */
public class TestJmsQueueProducer {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("queue-producer.xml");
		ProducerService pService = ac.getBean(ProducerServiceImpl.class);
		Student student = null;
		for (int i = 0; i < 10; i++) {
			student = new Student();
			student.setSno(20171112);
			student.setName("消息:" + i);
			student.setEmail("zhangsan@jj.com");
			student.setRegisterTime(new Date());
			pService.sendMessage(student);
		}
		/*for (int i = 0; i <10; i++) {
			pService.sendMessage("文本消息："+i);
		}*/
		// 关闭上下文
		ac.close();
	}
}
