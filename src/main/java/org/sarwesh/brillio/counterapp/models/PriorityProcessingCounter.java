package org.sarwesh.brillio.counterapp.models;

public class PriorityProcessingCounter extends BaseCounter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String COUNTER_PREFIX = "PRIORITY PROCESSING Counter-";
	public String getCounterName()
	{
		return COUNTER_PREFIX + getCounterNumber();
	}

	public PriorityProcessingCounter()
	{
		super();
	}
}
