package com.multithreading.controller;

import com.multithreading.enums.Options;
import com.multithreading.service.TimerService;
import com.multithreading.view.UI;

public class TimerController {

	private TimerService service;

	public TimerController(TimerService service) {
		this.service = service;
		this.run();
	}

	public void run() {

		boolean isRunning = true;

		while (isRunning) {

			UI.getMenu();

			Options choice = UI.userChoice();

			switch (choice) {
				case EXIT:
					service.closeAllTimers();
					service.closePool();
					System.out.println("byebye");
					System.exit(0);
					break;
				case STOP:
					service.stop(UI.getTimerName());
					break;
				case CHECK:
					service.check(UI.getTimerName());
					break;
				case START:
					service.start(UI.getTimerName());
					break;
			}
		}
	}
}
