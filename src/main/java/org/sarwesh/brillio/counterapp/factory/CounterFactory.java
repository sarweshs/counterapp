package org.sarwesh.brillio.counterapp.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.sarwesh.brillio.counterapp.models.BaseCounter;
import org.sarwesh.brillio.counterapp.models.NormalProcessingCounter;
import org.sarwesh.brillio.counterapp.models.PriorityProcessingCounter;

public class CounterFactory {
	private static final List<BaseCounter> priorityProcessingCounter = new ArrayList<>();
	private static final List<BaseCounter> normalProcessingCounter = new ArrayList<>();
	private static final Random random = new Random();

	static {
		for(int i=0; i<10;i++)
		{
			BaseCounter b = new NormalProcessingCounter();
			b.setCounterNumber(i);
			normalProcessingCounter.add(b);
		}
		
		for(int i=0; i<3;i++)
		{
			BaseCounter b = new PriorityProcessingCounter();
			b.setCounterNumber(i);
			priorityProcessingCounter.add(b);
		}
	}
	
	public static BaseCounter getNextAvailableNormalCounter()
	{
		int randomInteger = random.nextInt(normalProcessingCounter.size()-1);
		return normalProcessingCounter.get(randomInteger);
	}
	
	public static BaseCounter getNextAvailablePriorityCounter()
	{
		int randomInteger = random.nextInt(priorityProcessingCounter.size()-1);
		return priorityProcessingCounter.get(randomInteger);
	}
}
