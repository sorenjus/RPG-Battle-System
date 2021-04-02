package com.base.engine;

import static org.lwjgl.opengl.GL11.*;

/**
 * Class for all in-game objects with sprites
 *
 * @author Jason Truskowski
 */
public abstract class GameObject {
	/**
	 * Coordinates of the GameObject on the overworld
	 *
	 */
	protected float x, y;
	private Animation animation;
	protected Sprite sprite;

	public void update() {

	}

	/**
	 * Renders the sprites for game objects
	 *
	 */

	public void render() {
		glPushMatrix();

		glTranslatef(x,y,0);
		sprite.render();

		glPopMatrix();
	}

	/**
	 * Return the value of X
	 * @return float
	 */
	public float getX() {
		return x;
	}

	/**
	 * Return the value of Y
	 * @return float
	 */
	public float getY() {
		return y;
	}

	/**
	 * Return the size value of X
	 * @return float
	 */
	public float getSizeX() {
		return sprite.getSizeX();
	}

	/**
	 * Return the size value of Y
	 * @return float
	 */
	public float getSizeY() {
		return sprite.getSizeY();
	}

	/**
	 * Initialize the sprite
	 *
	 * @param x default horizontal
	 * @param y default vertical location
	 * @param r Red value
	 * @param g Green value
	 * @param b Blue value
	 * @param sx Horizontal length
	 * @param sy Vertical height
	 */
	public void init(float x, float y, float r, float g, float b, float sx, float sy) {
		this.x = x;
		this.y = y;
		this.sprite = new Sprite(r,g,b,sx,sy);
	}
}
