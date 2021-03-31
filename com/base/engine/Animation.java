package com.base.engine;

import java.util.ArrayList;

public class Animation {
	/**
	 * Stores all of the frames in the animation in order
	 */
	private ArrayList<Frame> frames;

	/**
	 * The index of the frame the animation is currently on
	 */
	private int currentFrame;

	/**
	 * Default constructor for a new animation
	 */
	public Animation() {
		frames = new ArrayList<Frame>();
	}

	/**
	 * Renders the current frame of the animation
	 */
	public void render() {
		Frame temp = frames.get(currentFrame);

		if(temp.render()) {
			// Advance to the next frame, or return to the first frame if on the last
			currentFrame++;
			currentFrame %= frames.size();
		}
	}
}