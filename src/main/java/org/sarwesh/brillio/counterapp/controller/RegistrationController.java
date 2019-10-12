package org.sarwesh.brillio.counterapp.controller;

import org.sarwesh.brillio.counterapp.kafka.MessageProducer;
import org.sarwesh.brillio.counterapp.models.RegistrationDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController implements ApplicationContextAware{
	Logger LOG = LoggerFactory.getLogger(RegistrationController.class);
	private ApplicationContext context;
    
	@GetMapping("/new")
	public String register(RegistrationDetails registrationDetails) {
		return "registration";
	}
	
	@PostMapping("/doRegister")
	public String doRegister(RegistrationDetails registrationDetails) {
		LOG.info(registrationDetails.getName());
		LOG.info(registrationDetails.getRegistrationCounter().getCounterName());
		LOG.info(""+registrationDetails.getPriority());
		MessageProducer producer = context.getBean(MessageProducer.class);
		producer.sendMessage(registrationDetails);
		return "index";
	}

	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		this.context = ctx;
	}
}
