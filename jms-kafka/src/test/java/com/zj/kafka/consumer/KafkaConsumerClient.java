package com.zj.kafka.consumer;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

/**
 * 
 * @Description: kafka消费者java代码
 * @author Jian Jang
 * @version 1.0 2017年10月18日
 */
public class KafkaConsumerClient {
	public static void main(String[] args) {
		Properties props = new Properties();
		props.put("bootstrap.servers",
				"192.168.127.128:9092,192.168.127.129:9092,192.168.127.130:9092");
		props.put("group.id", "test");
		props.put("enable.auto.commit", "true");
		props.put("auto.commit.interval.ms", "1000");
		props.put("session.timeout.ms", "30000");
		//props.put("auto.offset.reset", "earliest");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		@SuppressWarnings("resource")
		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
		consumer.subscribe(Arrays.asList("kafka_demo"));
		while (true) {
			ConsumerRecords<String, String> records = consumer.poll(1000000);
			for (ConsumerRecord<String, String> record : records)
				System.out.printf("offset = %d, key = %s, value = %s", record.offset(),
						record.key(), record.value());
		}
	}

}