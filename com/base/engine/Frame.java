package com.base.engine;

public class Frame {
	/**
	 * The sprite being displayed
	 */
	private Sprite sprite;
	/**
	 * The number of frames the sprite should be displayed for
	 */
	private int length;
	/**
	 * The number of frames the sprite has actually been displayed for
	 */
	private int timeDisplayed;

	/**
	 * Default constructor for a frame
	 *
	 * @param s The sprite to be displayed
	 * @param len The number of frames the sprite should be displayed for
	 */
	public Frame(Sprite s, int len) {
		this.sprite = s;
		this.length = len;
		timeDisplayed = 0;
	}

	/**
	 * Renders the current sprite for the appropriate amount of frames
	 *
	 * @return true if the sprite has been rendered the specified amount of frames
	 */
	public boolean render() {
		sprite.render();
		timeDisplayed++;

		if(timeDisplayed >= length) {
			timeDisplayed = 0;
			return true;
		}

		return false;
	}
}