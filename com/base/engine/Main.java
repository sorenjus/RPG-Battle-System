package com.base.engine;

import com.base.game.Game;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

import java.util.ArrayList;

import static org.lwjgl.opengl.GL11.*;

//import org.lwjgl.LWJGLException;
//import static Store.Tex.BeginSession;
//import static Store.Tex.LoadTexture;
//import static Store.Tex.*;

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
    private static void initGame() {
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

        while (!Display.isCloseRequested()) {

            Display.update();
            Display.sync(60);
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
        Display.sync(60);
    }

    public static ArrayList<GameObject> inRadius(float x, float y, float radius) {
        return game.inRadius(x, y, radius);
    }

    /**
     * Disables the display and input device when the program is closed
     */
    private static void cleanUp() {
        Display.destroy();
        Keyboard.destroy();
    }
}