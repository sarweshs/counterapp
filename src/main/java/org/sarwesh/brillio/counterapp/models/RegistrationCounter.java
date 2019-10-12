package org.sarwesh.brillio.counterapp.models;

public class RegistrationCounter extends BaseCounter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final String COUNTER_PREFIX = "REGISTRATION COUNTER-";
	
	public String getCounterName()
	{
		return COUNTER_PREFIX + getCounterNumber();
	}
	public RegistrationCounter()
	{
		super();
	}
}
