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
	private ArrayList<GameObject> objects;
	private Character player;

	public Game(){
		objects = new ArrayList<GameObject>();
		player = new Character(Display.getWidth() / 2 - Character.SIZE / 2, Display.getHeight() / 2 - Character.SIZE /2);
		objects.add(player);
	}
	/**
	 * Receives player input
	 */
	public void getInput() {

	}

	/**
	 * Updates the state of the game
	 */
	public void update() {
		for(GameObject go : objects)
			go.update();
	}

	/**
	 * Updates the displayed graphics
	 */
	public void render() {
		for(GameObject go : objects)
			go.render();
	}
}