package org.sarwesh.brillio.counterapp;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.sarwesh.brillio.counterapp.factory.CounterFactory;
import org.sarwesh.brillio.counterapp.kafka.MessageConsumer;
import org.sarwesh.brillio.counterapp.kafka.MessageProducer;
import org.sarwesh.brillio.counterapp.models.BaseCounter;
import org.sarwesh.brillio.counterapp.models.RegistrationCounter;
import org.sarwesh.brillio.counterapp.models.RegistrationDetails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@SpringBootApplication
public class CounterAppApplication {
	@Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(CounterAppApplication.class, args);
		MessageProducer producer = context.getBean(MessageProducer.class);
        //MessageConsumer listener = context.getBean(MessageConsumer.class);
        
        for (int i = 0; i < 1; i++) {
        	BaseCounter bc = new RegistrationCounter();
        	bc.setCounterNumber(i);
        	RegistrationDetails regDetails = new RegistrationDetails();
        	regDetails.setName("Candidate-"+i);
        	regDetails.setRegistrationCounter(bc);
            producer.sendMessage(regDetails);
        }
        for (int i = 0; i < 1; i++) {
        	BaseCounter bc = new RegistrationCounter();
        	bc.setCounterNumber(50 + i);
        	RegistrationDetails regDetails = new RegistrationDetails();
        	regDetails.setPriority(true);
        	regDetails.setName("Candidate-"+i);
        	regDetails.setRegistrationCounter(bc);
            producer.sendMessage(regDetails);
        }
	}

	@Bean
	public CounterFactory counterFactory() {
		return new CounterFactory();
	}

	@Bean
	public MessageProducer messageProducer() {
		return new MessageProducer();
	}

	@Bean
	public MessageConsumer messageListener() {
		return new MessageConsumer();
	}
	
	public ConsumerFactory<String, RegistrationDetails> registrationDetailsConsumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "greeting");
        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), new JsonDeserializer<>(RegistrationDetails.class));
    }
	
	 @Bean
	    public ConcurrentKafkaListenerContainerFactory<String, RegistrationDetails> registrationDetailsKafkaListenerContainerFactory() {
	        ConcurrentKafkaListenerContainerFactory<String, RegistrationDetails> factory = new ConcurrentKafkaListenerContainerFactory<>();
	        factory.setConsumerFactory(registrationDetailsConsumerFactory());
	        return factory;
	    }
}