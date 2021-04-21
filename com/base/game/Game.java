package com.base.game;

import com.base.engine.GameObject;
import com.base.engine.Physics;
import com.base.game.gameobjects.PlayerCharacter;
import org.lwjgl.opengl.Display;

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
     * The player character for the current game
     */
    private transient final PlayerCharacter player;

    /**
     * Default game constructor
     */
    public Game() {
        objects = new ArrayList<>();
        player = new PlayerCharacter(Display.getWidth() / 2 - PlayerCharacter.SIZE / 2, Display.getHeight() / 2 - PlayerCharacter.SIZE / 2);
        objects.add(player);
        objects.add(new GenericRedSquareOfDeath(150, 250, 1));
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
            go.update();
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

    public ArrayList<GameObject> inRadius(float x, float y, float radius) {
        ArrayList<GameObject> inRadius = new ArrayList<GameObject>();

        for(GameObject ob : objects) {
            if(Physics.getDistance(ob.getX(), ob.getY(), x, y) < radius) {
                inRadius.add(ob);
            }
        }


        return inRadius;
    }
}