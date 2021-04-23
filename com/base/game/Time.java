package com.base.game;

/**
 * Class that manages time for cooldown
 *
 * @author Jason Truskowski
 */
public class Time {
	/**
	 * The time when the current and last frames started on
	 */
	private static long curFrameStart, lastFrameStart;

	/**
	 * Initializes the time the current and last frames started on
	 */
	public static void init() {
		curFrameStart = getTime();
		lastFrameStart = getTime();
	}

	/**
	 * Gets the elapsed time in nanoseconds
	 *
	 * @return Elapsed time in nanoseconds
	 */
	public static long getTime() {
		return System.nanoTime();
	}

	/**
	 * Advances frames and updates the starting time of the new and previous frames
	 */
	public static void update() {
		lastFrameStart = curFrameStart;
		curFrameStart = getTime();
	}
}