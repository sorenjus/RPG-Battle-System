package com.base.engine;

import com.base.game.Game;
import com.base.game.Time;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

import java.util.ArrayList;

import static org.lwjgl.opengl.GL11.*;

/**
 * The main class of the program that opens and closes the game and manages the game loop.
 *
 * @author Jason Truskowski
 */
public class Main {
    /**
     * The RPG battle system game
     */
    private static Game game;

    /**
     * Creates the game, calls the game loop, and cleans up everything on game close
     *
     * @param args
     */
    public static void main(final String[] args) {
        initDisplay();
        initGL();
        initGame();
        gameLoop();
        cleanUp();
    }

    /**
     * Creates the display window for the game
     */
    private static void initDisplay() {
        //Display.setDisplayMode(new DisplayMode(800, 600));
        //Display.create();
        Store.beginSession();
        //new Main();
    }

    /**
     * Initializes openGL settings
     */
    private static void initGL() {
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, Display.getWidth(), 0, Display.getHeight(), -1, 1);
        glMatrixMode(GL_MODELVIEW);
        glDisable(GL_DEPTH_TEST);
        glClearColor(0, 0, 0, 0);
    }

    /**
     * Creates a new game
     */
    public static void initGame() {
        game = new Game();
    }

    /**
     * Repeatedly updates the game state until the program is closed
     */
    private static void gameLoop() {
        final int[][] map = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        final TileGrid grid = new TileGrid(map);
        grid.draw();
        Time.init();
        while (!Display.isCloseRequested()) {
            Time.update();
            getInput();
            update();
            render();
        }
    }

    /**
     * Receives player input
     */
    private static void getInput() {
        game.returnInput();
    }

    /**
     * Updates the state of the game
     */
    private static void update() {
        game.update();
    }

    /**
     * Updates the displayed graphics
     */
    private static void render() {
        glClear(GL_COLOR_BUFFER_BIT);
        glLoadIdentity();
        game.render();
        Display.update();
    }

    /**
     * Determines the GameObjects that fall within a certain radius of a starting point
     *
     * @param x The x-coordinate of the point
     * @param y The y-coordinate of the point
     * @param radius The radius of the area around the point being checked
     * @return An ArrayList of all the GameObjects in the radius
     */
    public static ArrayList<GameObject> inRadius(float x, float y, float radius) {
        return game.inRadius(x, y, radius);
    }

    /**
     * Determines the GameObjects that are in front of a certain area
     *
     * @param x1 The starting x coordinate of the area
     * @param y1 The starting y coordinate of the area
     * @param x2 The ending x coordinate of the area
     * @param y2 The ending y coordinate of the area
     * @return An ArrayList of all the GameObjects in the area
     */
    public static ArrayList<GameObject> inFront(float x1, float y1, float x2, float y2) {
    	return game.inFront(x1, y1, x2, y2);
    }

    /**
     * Disables the display and input device when the program is closed
     */
    private static void cleanUp() {
        Display.destroy();
        Keyboard.destroy();
    }
}