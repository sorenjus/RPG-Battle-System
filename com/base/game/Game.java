package com.base.game;

import com.base.engine.GameObject;
import com.base.engine.Physics;
import com.base.game.Item.Cap;
import com.base.game.Item.ChainMail;
import com.base.game.Item.ChainPants;
import com.base.game.Item.Sword;
import com.base.game.gameobjects.GenericRedSquareOfDeath;
import com.base.game.gameobjects.PlayerCharacter;
import org.lwjgl.opengl.Display;

import java.awt.*;
import java.util.ArrayList;

/**
 * Class for functions performed by the game
 *
 * @author Jason Truskowski
 */
public class Game {
    /**
     * Stores all existing GameObjects (player, enemies, etc.)
     */
    private transient final ArrayList<GameObject> objects;
    /**
     * Stores all items to be removed
     */
    private transient final ArrayList<GameObject> remove;
    /**
     * The player character for the current game
     */
    private transient final PlayerCharacter player;

    /**
     * Default game constructor
     */
    public Game() {
        objects = new ArrayList<>();
        remove = new ArrayList<>();

        player = new PlayerCharacter(Display.getWidth() / 2 - PlayerCharacter.SIZE / 2, Display.getHeight() / 2 - PlayerCharacter.SIZE / 2);
        objects.add(player);
        objects.add(new Sword(350,400));
        objects.add(new ChainMail(50,400));
        objects.add(new ChainPants(100,500));
        objects.add(new Cap(150,300));
        objects.add(new GenericRedSquareOfDeath(150, 250, 1, 2, 1, 50));
        objects.add(new GenericRedSquareOfDeath(200, 500, 1, 2, 1, 50));
        objects.add(new GenericRedSquareOfDeath(500, 450, 1, 2, 1, 50));
        objects.add(new GenericRedSquareOfDeath(600, 100, 1, 2, 1, 50));
    }

    /**
     * Receives player input
     */
    public void returnInput() {
        player.returnInput();
    }

    /**
     * Updates the state of the game
     */
    public void update() {
        for (final GameObject go : objects) {
            if(!go.getDelete())
            {
                go.update();
            }
            else
            {
                remove.add(go);
            }
        }
        for(final GameObject go : remove)
        {
            objects.remove(go);
        }
    }

    /**
     * Updates the displayed graphics
     */
    public void render() {
        for (final GameObject go : objects) {
            go.render();
        }
    }

    /**
     * Determines all the GameObjects within a certain radius
     *
     * @param xCoord x coordinate of the center of the circle
     * @param yCoord y coordinate of the center of the circle
     * @param radius Radius around the center being checked
     * @return All of the GameObjects within the specified radius
     */
    public ArrayList<GameObject> inRadius(final float xCoord, final float yCoord, final float radius) {
        final ArrayList<GameObject> inRadius = new ArrayList<>();

        for(final GameObject ob : objects) {
            if(Physics.getDist(ob.getX(), ob.getY(), xCoord, yCoord) < radius) {
                inRadius.add(ob);
            }
        }

        return inRadius;
    }

    /**
     * Determines all the GameObjects in a certain range in front of the player
     *
     * @param firstxCoord Starting x coordinate of detection box
     * @param firstyCoord Starting y coordinate of detection box
     * @param secondxCoord Ending x coordinate of detection box
     * @param secondyCoord Ending y coordinate of detection box
     * @return All of the GameObjects within the detection box
     */
    public ArrayList<GameObject> inFront(final float firstxCoord, final float firstyCoord, final float secondxCoord, final float secondyCoord) {
        final ArrayList<GameObject> inFront = new ArrayList<>();

        final float width = secondxCoord - firstxCoord;
        final float height = secondyCoord - firstyCoord;

        final Rectangle detection = new Rectangle((int)firstxCoord, (int)firstyCoord, (int)width, (int)height);

        for(final GameObject ob : objects) {
            if(Physics.areColliding(detection, ob) != null) {
                inFront.add(ob);
            }
        }

        return inFront;
    }
}