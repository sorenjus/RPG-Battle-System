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
    public static GameObject areColliding(GameObject object1, GameObject object2) {
        return areColliding(new Rectangle((int)object1.getX(), (int)object1.getY(),
                (int)object1.getSizeX(), (int)object1.getSizeY()), object2);
    }

    /**
     * A helper method for the other areColliding method that checks if a rectangle
     * (either another GameObject or a detection box) is colliding with a second
     * GameObject
     *
     * @param r The collision detection box
     * @param g The GameObject that is being checked with the collision box
     * @return Whether the GameObject is inside the detection box
     */
    public static GameObject areColliding(Rectangle r, GameObject g) {
        final Rectangle hitbox = new Rectangle((int) g.getX(), (int) g.getY(), (int) g.getSizeX(), (int) g.getSizeY());

        if(r.intersects(hitbox)) {
            return g;
        } else {
            return null;
        }
    }

    public static boolean inLineOfSight(GameObject object1, GameObject object2) {
        return true;
    }

    /**
     * Calculates the distance between two points
     *
     * @param x1 The starting x coordinate
     * @param y1 The starting y coordinate
     * @param x2 The ending x coordinate
     * @param y2 The ending y coordinate
     * @return The calculated distance between (x1, y1) and (x2, y2)
     */
    public static float getDist(float x1, float y1, float x2, float y2) {
        return (float)Math.sqrt(((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1)));
    }
}
