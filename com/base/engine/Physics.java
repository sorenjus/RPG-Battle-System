package com.base.engine;

import java.awt.*;

public class Physics {
	public static boolean areColliding(GameObject g1, GameObject g2) {
		Rectangle hitbox1 = new Rectangle((int)g1.getX(), (int)g1.getSizeX(), (int)g1.getY(), (int)g1.getSizeY());
		Rectangle hitbox2 = new Rectangle((int)g2.getX(), (int)g2.getSizeX(), (int)g2.getY(), (int)g2.getSizeY());

		return hitbox1.intersects(hitbox2);
	}
}
