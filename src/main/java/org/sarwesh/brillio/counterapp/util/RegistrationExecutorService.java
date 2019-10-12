package org.sarwesh.brillio.counterapp.util;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class RegistrationExecutorService {

	private static final BlockingQueue<Runnable> normalBlockingQueue = new ArrayBlockingQueue<Runnable>(50);
	private static final BlockingQueue<Runnable> priorityBlockingQueue = new ArrayBlockingQueue<Runnable>(50);

	private static final CustomThreadPoolExecutor normalExecutorService = new CustomThreadPoolExecutor(10, 20, 5000,
			TimeUnit.MILLISECONDS, normalBlockingQueue);

	private static final CustomThreadPoolExecutor priorityExecutorService = new CustomThreadPoolExecutor(10, 20, 5000,
			TimeUnit.MILLISECONDS, priorityBlockingQueue);

	public static CustomThreadPoolExecutor getNormalexecutorservice() {
		return normalExecutorService;
	}

	public static CustomThreadPoolExecutor getPriorityexecutorservice() {
		return priorityExecutorService;
	}

}
