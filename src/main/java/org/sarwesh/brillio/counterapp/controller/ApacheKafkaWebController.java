package org.sarwesh.brillio.counterapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/register/")
public class ApacheKafkaWebController {
	Logger LOG = LoggerFactory.getLogger(ApacheKafkaWebController.class);


	// @Autowired
	// KafkaSender kafkaSender;

	@GetMapping(value = "/counter")
	public String producer(@RequestParam("message") String message) {
		// kafkaSender.send(message);

		return "Message sent to the Kafka Topic java_in_use_topic Successfully";
	}

}
