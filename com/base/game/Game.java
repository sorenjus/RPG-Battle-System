package com.base.game;

import com.base.engine.GameObject;
import com.base.game.gameobjects.Character;
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
    private transient final Character player;

    /**
     * Default game constructor
     */
    public Game() {
        objects = new ArrayList<>();
        player = new Character(Display.getWidth() / 2 - Character.SIZE / 2, Display.getHeight() / 2 - Character.SIZE / 2);
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
}