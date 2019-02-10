package com.multithreading.view;

import com.multithreading.enums.Options;

import java.util.Arrays;
import java.util.Scanner;

public class UI {


	public static String getTimerName() {
		System.out.println("Type Timer name: ");
		Scanner scanner = new Scanner(System.in);
		return scanner.next();
	}

	public static Options userChoice() {
		System.out.println("Choose option: ");
		Scanner scanner = new Scanner(System.in);

		Integer user = scanner.nextInt();

		return user >= 0 && user < 4 ? Options.values()[user] : userChoice();
	}

	public static void getMenu() {
		Arrays.stream(Options.values()).forEach(e -> System.out.println(e.ordinal() + "." + e.name()));
	}



}
