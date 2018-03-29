package com.jianzhang.jms.message.service.queue.listener;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class MyListener {
	Logger logger =Logger.getLogger(this.getClass());

	public void listen(String message) {
		logger.info("接收到消息:" + message);
	}
}
