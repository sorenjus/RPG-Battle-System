package com.base.engine;

import static org.lwjgl.opengl.GL11.*;

/**
 * This class handles the drawing and size of ingame sprites
 *
 * @author Jason Truskowski
 */
public class Sprite {

	/**
	 * The color values for the sprite
	 */
	private float red, green, blue;

	/**
	 * The horizontal and vertical size values for the sprite
	 */
	private float sizex, sizey;

	/**
	 * Default constructor for a sprite
	 *
	 * @param r Red value
	 * @param g Green value
	 * @param b Blue value
	 * @param sx Horizontal length
	 * @param sy Vertical height
	 */
	public Sprite(float r, float g, float b, float sx, float sy) {
		this.red = r;
		this.green = g;
		this.blue = b;
		this.sizex = sx;
		this.sizey = sy;
	}

	/**
	 *
	 * @return The (horizontal) length of the sprite
	 */
	public float getSizeX() {
		return sizex;
	}

	/**
	 *
	 * @return The (vertical) height of the sprite
	 */
	public float getSizeY() {
		return sizey;
	}

	/**
	 *
	 * @param sx The desired sprite length
	 */
	public void setSizeX(float sx) {
		this.sizex = sx;
	}

	/**
	 *
	 * @param sy The desired sprite height
	 */
	public void setSizeY(float sy) {
		this.sizey = sy;
	}

	/**
	 * Draws the sprite
	 */
	public void render() {
		glColor3f(red,green,blue);
		glBegin(GL_QUADS);

		// Drawing a simple rectangle as a placeholder
		// TODO: Implement actual sprites later
		glVertex2f(0,0);
		glVertex2f(0,sizey);
		glVertex2f(sizex,sizey);
		glVertex2f(sizex,0);

		glEnd();
	}
}
