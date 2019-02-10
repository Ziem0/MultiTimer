package com.multithreading;


import com.multithreading.controller.TimerController;
import com.multithreading.service.TimerService;

public class App {

	public static void main(String[] args) {
		TimerController timerController = new TimerController(new TimerService());
		timerController.run();
	}

}
