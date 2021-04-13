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
	 * @param object1 The first of the two GameObjects
	 * @param object2 The second of the two GameObjects
	 * @return true if the GameObjects are occupying the same space, false if not
	 */
	public static boolean areColliding(final GameObject object1,final GameObject object2) {
		final Rectangle hitbox1 = new Rectangle((int)object1.getX(), (int)object1.getSizeX(), (int)object1.getY(), (int)object1.getSizeY());
		final Rectangle hitbox2 = new Rectangle((int)object2.getX(), (int)object2.getSizeX(), (int)object2.getY(), (int)object2.getSizeY());

		return hitbox1.intersects(hitbox2);
	}
}
