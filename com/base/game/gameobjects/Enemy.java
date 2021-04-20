package com.base.game.gameobjects;

import com.base.engine.GameObject;
import com.base.engine.Physics;

public class Enemy extends GameObject {
	private Stats enStats;
	private GameObject target;

	public Enemy(float x, float y, int level) {
		enStats = new Stats(level, false);
		target = null;
	}

	public static int levelToExp(int level) {
		return 0;
	}

	@Override
	public void update() {
		if(target == null) {
			look();
		} else {
			chase();
			if(Physics.inLineOfSight(this, target)) {
				attack();
			}
		}

		if(enStats.getHP() <= 0) {
			die();
		}
	}

	protected void attack() {

	}

	protected void look() {

	}

	protected void chase() {

	}

	protected void die() {

	}
}
