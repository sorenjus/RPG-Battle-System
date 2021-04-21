package com.base.game;

public class Cooldown {
	private int time;
	private long coolDownEnd;
	private boolean started;

	public Cooldown(int time) {
		this.time = time;
		started = false;
	}

	public void start() {
		started = true;
		coolDownEnd = time * 1000000 + Time.getTime();
	}

	public boolean isStarted() {
		return started;
	}

	public void stop() {
		started = true;
		coolDownEnd = 0;
	}

	public void reset() {
		started = false;
	}

	public boolean isCooldownOver() {
		if(!started) {
			return false;
		}
		return Time.getTime() >= coolDownEnd;
	}
}
