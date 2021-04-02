package com.base.engine;

import java.awt.*;

/**
 * This class handles specific physics of the game
 *
 * @author Jason Truskowski
 */
public class Physics {
	/**
	 * A simple collision detection system for GameObjects
	 *
	 * @param g1 The first of the two GameObjects
	 * @param g2 The second of the two GameObjects
	 * @return true if the GameObjects are occupying the same space, false if not
	 */
	public static boolean areColliding(GameObject g1, GameObject g2) {
		Rectangle hitbox1 = new Rectangle((int)g1.getX(), (int)g1.getSizeX(), (int)g1.getY(), (int)g1.getSizeY());
		Rectangle hitbox2 = new Rectangle((int)g2.getX(), (int)g2.getSizeX(), (int)g2.getY(), (int)g2.getSizeY());

		return hitbox1.intersects(hitbox2);
	}
}
