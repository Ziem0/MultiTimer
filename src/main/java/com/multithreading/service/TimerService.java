package com.multithreading.service;

import com.multithreading.model.MyTimer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TimerService {

	private ExecutorService threadpool = Executors.newCachedThreadPool();
	private List<MyTimer> timers = new ArrayList<>();

	private Optional<MyTimer> getTimer(String name) {
		return timers.stream()
				.filter(e -> e.getName().equalsIgnoreCase(name))
				.findFirst();
	}

	/*
	If Timer exists, it runs previously stopped timer;
	If Timer doesn't exist, it creates new Timer and add to timers list
	 */
	public void start(String name) {
		Optional<MyTimer> optionalTimer = getTimer(name);
		if (optionalTimer.isPresent()) {
			optionalTimer.get().handleNextRunning();
		} else if (name.equalsIgnoreCase("all")) {
			//keyword 'all' cant be a name for a thread. It uses to show all threads statistics
		} else {
			MyTimer myTimer = new MyTimer(name);
			timers.add(myTimer);
			threadpool.submit(myTimer);
		}
	}

	/*
	If timer exists and is running, it stop running
	 */
	public void stop(String name) {
		Optional<MyTimer> optionalTimer = getTimer(name);
		optionalTimer.ifPresent(MyTimer::stopRunning);
	}

	public void check(String name) {
		Optional<MyTimer> optionalTimer = getTimer(name);
		if (optionalTimer.isPresent()) {
			System.out.println(optionalTimer.get());
		} else {
			timers.forEach(System.out::println);
		}
	}

	public void closeAllTimers() {
		timers.forEach(MyTimer::setClosed);
	}

	public void closePool() {
		threadpool.shutdownNow();
	}

}
