package com.multithreading.model;

public class MyTimer implements Runnable{

	private String name;
	private int seconds;
	private boolean isRunning;
	private boolean isClosed;

	public MyTimer(String name) {
		this.name = name;
		this.seconds = 0;
		this.isRunning = true;
		this.isClosed = false;
	}

	public String getName() {
		return name;
	}

	@Override
	public void run() {
		while (!isClosed) {
			try {
				Thread.sleep(1000);
				if (isRunning) {
					seconds++;
				}
			} catch (InterruptedException e) {
			}
		}
	}

	public void setClosed() {
		isClosed = true;
	}

	public void handleNextRunning() {
		if (!isRunning) {
			isRunning = true;
		} else {
			seconds = 0;
		}
	}

	public void stopRunning() {
		isRunning = false;
	}

	@Override
	public String toString() {
		return String.format("name:%s seconds:%d", this.name, this.seconds);
	}
}
