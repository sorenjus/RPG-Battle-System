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

	/**
	 * Updates the state of a GameObject
	 */
	public void update() {

	}

	/**
	 * Renders the sprites
	 */
	public void render() {
		glPushMatrix();

		glTranslatef(x,y,0);
		sprite.render();

		glPopMatrix();
	}

	/**
	 * Returns the the x position of the sprite
	 * @return returns the cartesian x of where the sprite is
	 */
	public float getX() {
		return x;
	}

	/**
	 * Returns the the y position of the sprite
	 * @return returns the cartesian y of where the sprite is
	 */
	public float getY() {
		return y;
	}

	/**
	 * Returns the the size of the sprite on x cartexian
	 * @return returns the cartesian x of how big the sprite is
	 */
	public float getSizeX() {
		return sprite.getSizeX();
	}

	/**
	 * Returns the the size of the sprite on y cartexian
	 * @return returns the cartesian y of how big the sprite is
	 */

	public float getSizeY() {
		return sprite.getSizeY();
	}

	public float getSX() { return sprite.getSizeX(); }

	public float getSY() { return sprite.getSizeY(); }

	/**
	 * Constructs a sprite
	 *
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
