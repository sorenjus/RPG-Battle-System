package com.base.game;

import com.base.game.gameobjects.Enemy;

public class GenericRedSquareOfDeath extends Enemy {

	public static final float SIZE = 32;

	public GenericRedSquareOfDeath(float x, float y, int level) {
		super(x, y, level);
		this.init(x, y, 1, 0, 0, SIZE, SIZE);
	}
}
