package org.sarwesh.brillio.counterapp.service;

import org.springframework.kafka.core.KafkaTemplate;

//@Service
public class KafkaSender {

	//@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	String kafkaTopic = "normal";

	public void send(String data) {

		kafkaTemplate.send(kafkaTopic, data);
	}

	public void send(String topic, String data) {

		kafkaTemplate.send(topic, data);
	}
}