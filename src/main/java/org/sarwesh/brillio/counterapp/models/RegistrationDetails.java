package org.sarwesh.brillio.counterapp.models;

import java.io.Serializable;

public class RegistrationDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private BaseCounter registrationCounter = new RegistrationCounter();
	
	private Boolean priority = false;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getPriority() {
		return priority;
	}

	public void setPriority(Boolean priority) {
		this.priority = priority;
	}

	public BaseCounter getRegistrationCounter() {
		return registrationCounter;
	}

	public void setRegistrationCounter(BaseCounter registrationCounter) {
		this.registrationCounter = registrationCounter;
	}

}
