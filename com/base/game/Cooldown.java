package com.base.game;

/**
 * Class that handles attack cooldown
 *
 * @author Jason Truskowski
 */
public class Cooldown {
	/**
	 * The amount of time elapsed in ms
	 */
	private int time;

	/**
	 * When the cooldown ends
	 */
	private long coolDownEnd;

	/**
	 * Whether cooldown has started
	 */
	private boolean started;

	/**
	 * Constructs a new cooldown timer
	 *
	 * @param time How long cooldown should last
	 */
	public Cooldown(final int time) {
		this.time = time;
		started = false;
	}

	/**
	 * Begins cooldown
	 */
	public void start() {
		started = true;
		coolDownEnd = time * 1_000_000 + Time.getTime();
	}

	/**
	 * Determines if cooldown has started
	 *
	 * @return Whether cooldown has started
	 */
	public boolean isStarted() {
		return started;
	}

	/**
	 * Ends cooldown
	 */
	public void stop() {
		started = true;
		coolDownEnd = 0;
	}

	/**
	 * Resets cooldown to starting position
	 */
	public void reset() {
		started = false;
	}

	/**
	 * Determines if cooldown has ended
	 *
	 * @return True if cooldown has ended, false if not
	 */
	public boolean isCooldownOver() {
		if(!started) {
			return false;
		}
		return Time.getTime() >= coolDownEnd;
	}
}
