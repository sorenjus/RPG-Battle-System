package com.base.game;

import com.base.engine.GameObject;
import com.base.engine.Main;
import com.base.game.gameobjects.PlayerCharacter;
import com.base.game.gameobjects.Enemy;

import java.util.ArrayList;

public class GenericRedSquareOfDeath extends Enemy {

	public static final int SIZE = 32;
	public static final float SLOWDOWN = 0.5f;

	public GenericRedSquareOfDeath(float x, float y, int level) {
		super(x, y, level);
		this.init(x, y, 1f, 0f, 0f, SIZE, SIZE, 0);
	}

	@Override
	protected void look() {
		ArrayList<GameObject> seen = Main.inRadius(getX(), getY(), 150); // arbitrary test value

		for(GameObject seenOb : seen) {
			if(seenOb instanceof PlayerCharacter) {
				// System.out.println("see");
				setTarget(seenOb);
			}
		}
	}

	@Override
	protected void chase() {
		float speedX = getTarget().getX() - getX();
		float speedY = getTarget().getY() - getY();
		float speedCap = 4f * SLOWDOWN;

		if(speedX > speedCap) {
			speedX = speedCap;
		} else if(speedX < -speedCap) {
			speedX = -speedCap;
		}
		if(speedY > speedCap) {
			speedY = speedCap;
		} else if(speedY < -speedCap) {
			speedY = -speedCap;
		}

		setX(getX() + speedX);
		setY(getY() + speedY);
	}
}
