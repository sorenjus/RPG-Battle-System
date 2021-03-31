package com.base.engine;

import static org.lwjgl.opengl.GL11.*;

/**
 * Class for all in-game objects with sprites
 */
public abstract class GameObject {
	protected float x;
	protected float y;
	private Animation animation;
	protected Sprite sprite;

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

	public float getSX() { return sprite.getSizeX(); }

	public float getSY() { return sprite.getSizeY(); }

	public void init(float x, float y, float r, float g, float b, float sx, float sy) {
		this.x = x;
		this.y = y;
		this.sprite = new Sprite(r,g,b,sx,sy);
	}
}
