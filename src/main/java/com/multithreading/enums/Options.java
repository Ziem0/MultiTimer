package com.multithreading.enums;

import java.util.Arrays;

public enum Options {

	START,
	STOP,
	CHECK,
	EXIT;

	public static boolean contains(String userOption) {
		return Arrays.stream(Options.values())
				.anyMatch(e -> e.name().equalsIgnoreCase(userOption));
	}

	public static Options getOption(String userOption) {
		return Options.valueOf(userOption.toUpperCase());
	}
}
