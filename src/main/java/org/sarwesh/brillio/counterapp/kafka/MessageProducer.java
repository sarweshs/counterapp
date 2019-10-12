package org.sarwesh.brillio.counterapp.kafka;

import org.sarwesh.brillio.counterapp.models.RegistrationDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;


public  class MessageProducer {


    @Autowired
    private KafkaTemplate<String, RegistrationDetails> registrationKafkaTemplate;

    @Value(value = "${registrationdetails.topic.name}")
    private String topicName;


    public void sendMessage(RegistrationDetails registrationDetails) {
    	registrationKafkaTemplate.send(topicName, registrationDetails);
    }
}
