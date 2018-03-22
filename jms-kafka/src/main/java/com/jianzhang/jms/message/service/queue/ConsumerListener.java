package com.jianzhang.jms.message.service.queue;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.MessageListener;

public final class ConsumerListener implements MessageListener<String, String> {

	//private static final Logger logger = LoggerFactory.getLogger(ConsumerListener.class);

	@Override
	public void onMessage(ConsumerRecord<String, String> data) {
		System.out.println("消息主题： " + data.topic());
		System.out.println("消息key： " + data.key());
		System.out.println("消息value： " + data.value());
		System.out.println("消息offset： " + data.offset());
		System.out.println("消息partition： " + data.partition());
		System.out.println("接收到消息： " + data);
	}
}