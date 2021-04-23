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
    public static GameObject areColliding(final GameObject object1, final GameObject object2) {
        return areColliding(new Rectangle((int)object1.getX(), (int)object1.getY(),
                (int)object1.getSizeX(), (int)object1.getSizeY()), object2);
    }

    /**
     * A helper method for the other areColliding method that checks if a rectangle
     * (either another GameObject or a detection box) is colliding with a second
     * GameObject
     *
     * @param collisionBox The collision detection box
     * @param gameObject The GameObject that is being checked with the collision box
     * @return Whether the GameObject is inside the detection box
     */
    public static GameObject areColliding(final Rectangle collisionBox, final GameObject gameObject) {
        final Rectangle hitbox = new Rectangle((int) gameObject.getX(), (int) gameObject.getY(), (int) gameObject.getSizeX(), (int) gameObject.getSizeY());

        if(collisionBox.intersects(hitbox)) {
            return gameObject;
        } else {
            return null;
        }
    }

    public static boolean inLineOfSight(final GameObject object1, final GameObject object2) {
        return true;
    }

    /**
     * Calculates the distance between two points
     *
     * @param firstxCoord The starting x coordinate
     * @param firstyCoord The starting y coordinate
     * @param secondxCoord The ending x coordinate
     * @param secondyCoord The ending y coordinate
     * @return The calculated distance between (x1, y1) and (x2, y2)
     */
    public static float getDist(final float firstxCoord, final float firstyCoord, final float secondxCoord, final float secondyCoord) {
        return (float)Math.sqrt(((secondxCoord - firstxCoord) * (secondxCoord - firstxCoord)) + ((secondyCoord - firstyCoord) * (secondyCoord - firstyCoord)));
    }
}
