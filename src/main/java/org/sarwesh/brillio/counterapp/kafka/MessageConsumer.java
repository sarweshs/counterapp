package org.sarwesh.brillio.counterapp.kafka;

import org.sarwesh.brillio.counterapp.factory.CounterFactory;
import org.sarwesh.brillio.counterapp.models.RegistrationDetails;
import org.sarwesh.brillio.counterapp.util.RegistrationExecutorService;
import org.sarwesh.brillio.counterapp.util.RegistrationProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;


public  class MessageConsumer {
	Logger LOG = LoggerFactory.getLogger(MessageConsumer.class);


    @KafkaListener(topics = "${registrationdetails.topic.name}", containerFactory = "registrationDetailsKafkaListenerContainerFactory")
    public void greetingListener(RegistrationDetails registrationDetails) {
        LOG.info("Recieved greeting message: " + registrationDetails);
        RegistrationProcessor processor = new RegistrationProcessor();
        processor.setRegistrationDetails(registrationDetails);
        
        if(registrationDetails.getPriority().equals(Boolean.TRUE))
        {
        	processor.setCounter(CounterFactory.getNextAvailablePriorityCounter());
        	RegistrationExecutorService.getPriorityexecutorservice().execute(processor);
        }
        else
        {
        	
        	processor.setCounter(CounterFactory.getNextAvailableNormalCounter());
        	RegistrationExecutorService.getNormalexecutorservice().execute(processor);
        }
        
       // this.greetingLatch.countDown();
    }

}
