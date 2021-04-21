package com.base.game;

public class Time {
	private static long curFrameStart;
	private static long lastFrameStart;

	public static void init() {
		curFrameStart = getTime();
		lastFrameStart = getTime();
	}

	public static long getTime() {
		return System.nanoTime();
	}

	public static long getDelta() {
		return curFrameStart - lastFrameStart;
	}

	public static void update() {
		lastFrameStart = curFrameStart;
		curFrameStart = getTime();
	}
}
