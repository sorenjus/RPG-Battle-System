package com.base.engine;

/**
 * Class for all in-game objects with sprites
 */
public abstract class GameObject {
	private float x;
	private float y;
	private Animation animation;

	public void update() {

	}

	public void render() {

	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}
}
