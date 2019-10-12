package org.sarwesh.brillio.counterapp.models;

public class NormalProcessingCounter extends BaseCounter {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String COUNTER_PREFIX = "NORMAL PROCESSING Counter-";
	public String getCounterName()
	{
		return COUNTER_PREFIX + getCounterNumber();
	}
	
	public NormalProcessingCounter()
	{
		super();
	}
}
