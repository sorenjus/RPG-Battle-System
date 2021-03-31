package com.base.engine;

import static org.lwjgl.opengl.GL11.*;

/**
 * Class for all in-game objects with sprites
 */
public abstract class GameObject {
	private float x;
	private float y;
	private Animation animation;
	private Sprite sprite;

	public void update() {

	}

	public void render() {
		glPushMatrix();

		glTranslatef(x,y,0);
		sprite.render();

		glPopMatrix();
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public float getSizeX() {
		return sprite.getSizeX();
	}

	public float getSizeY() {
		return sprite.getSizeY();
	}
}
