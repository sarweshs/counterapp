package org.sarwesh.brillio.counterapp.util;

import java.io.Serializable;

import org.sarwesh.brillio.counterapp.models.BaseCounter;
import org.sarwesh.brillio.counterapp.models.RegistrationDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RegistrationProcessor implements Serializable, Runnable{
	Logger LOG = LoggerFactory.getLogger(RegistrationProcessor.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BaseCounter counter;
	
	private RegistrationDetails registrationDetails;

	@Override
	public void run() {
		try {
			int sleepTime = 3000;
			String message = "Hello " + registrationDetails.getName() + " Please report to " + getCounter().getCounterName() + " for completing the registration process.";
			if(registrationDetails.getPriority() == Boolean.TRUE)
			{
				sleepTime = 500;
				message = "Hello " + registrationDetails.getName() + " You have been selected for Brillio, Please report to the " 
						+ getCounter().getCounterName() + " for completing the onboarding process.";
			}
			Thread.sleep(sleepTime);
			LOG.info(message);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public RegistrationDetails getRegistrationDetails() {
		return registrationDetails;
	}

	public void setRegistrationDetails(RegistrationDetails registrationDetails) {
		this.registrationDetails = registrationDetails;
	}

	public BaseCounter getCounter() {
		return counter;
	}

	public void setCounter(BaseCounter counter) {
		this.counter = counter;
	}
	
	

}
