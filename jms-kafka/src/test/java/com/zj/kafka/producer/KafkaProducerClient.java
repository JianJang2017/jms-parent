package com.zj.kafka.producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

/***
 * 
 * @Description: kafka消息生产者
 * @author Jian Jang
 * @version 1.0 2018年3月22日
 */
public class KafkaProducerClient {

	public static void main(String[] args) {

		Properties props = new Properties();
		props.put("bootstrap.servers",
				"192.168.127.128:9092,192.168.127.129:9092,192.168.127.130:9092");
		props.put("acks", "all");
		props.put("retries", 0);
		props.put("batch.size", 16384);
		props.put("linger.ms", 1);
		props.put("buffer.memory", 33554432);
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		Producer<String, String> producer = new KafkaProducer<>(props);
		for (int i = 0; i < 100; i++) {
			producer.send(new ProducerRecord<String, String>("kafka_demo", Integer.toString(i),
					Integer.toString(i)), new Callback() {

				@Override
				public void onCompletion(RecordMetadata paramRecordMetadata,
						Exception paramException) {
					if (equals(paramException != null)) {
						paramException.printStackTrace();
					}
					System.out.println(paramRecordMetadata.partition());
				}
			});
			//如果不flush，消费端接收不到消息
			producer.flush();
		}
		 producer.close();
	}

}