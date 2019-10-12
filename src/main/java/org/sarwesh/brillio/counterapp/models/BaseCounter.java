package org.sarwesh.brillio.counterapp.models;

import java.io.Serializable;

public  class BaseCounter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BaseCounter()
	{
		
	}
	
	private Integer counterNumber;

	public Integer getCounterNumber() {
		return counterNumber;
	}

	public void setCounterNumber(Integer counterNumber) {
		this.counterNumber = counterNumber;
	}
	
	public  String getCounterName()
	{
		return "Base Counter";
	}

}
